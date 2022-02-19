package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;
import com.trkj.balance.modules.salary_management.mapper.CompensationDeptPostMapper;
import com.trkj.balance.modules.salary_management.mapper.CompensationMapper;
import com.trkj.balance.modules.salary_management.mapper.DeptPostMapper;
import com.trkj.balance.modules.salary_management.service.CompensationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 薪酬组表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Service
public class CompensationServiceImpl extends ServiceImpl<CompensationMapper, Compensation> implements CompensationService {

    //薪酬组
    @Autowired
    private CompensationMapper compensationMapper;

    //薪酬组部门职位表
    @Autowired
    private CompensationDeptPostMapper compensationDeptPostMapper;

    //部门职位表
    @Autowired
    private DeptPostMapper deptPostMapper;

    @Override
    @Transactional
    public int insertCompensation(Compensation compensation, ArrayList<Integer> deptIds, ArrayList<Integer> postIds) {
       //添加薪酬组
        if(compensationMapper.insert(compensation)>0 ){
            // 声明一个实体类
            CompensationDeptPost compensationDeptPost=new CompensationDeptPost();
            //将新加的薪酬组id 作为薪酬组部门职位表的外键
            compensationDeptPost.setCompensationId(compensation.getCompensationId());

            // 使用双层for循环 按部门id和职位偶读查询部门职位中间表的id
            for (int i=0;i<deptIds.size();i++){ // 循环部门id
                for (int j=0;j<postIds.size();j++){ // 循环职位id
                    // 拿到部门id和职位id 去查询部门职位中间表的id
                    Long deptPostId=deptPostMapper.selectDeptPost(deptIds.get(i),postIds.get(j));
                    // 如果id为空 则 换下一个id继续查询
                    if(deptPostId==null){
                        continue; // 结束此次循环，j++ 再次循环
                    }
                    // 将查询出来的部门职位中间表id，加入薪酬组部门职位中间表中
                    compensationDeptPost.setDeptPostId(deptPostId);
                    //添加薪酬组部门职位表
                    if(compensationDeptPostMapper.insert(compensationDeptPost)<1){
                        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                        // 手动回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return 0;
                    }
                }
            }

        }
        // 执行完成，添加成功
        return 1;
    }

    //查询薪酬组名称
    @Override
    public List<Map<String, Object>> selectCompensationName() {
        QueryWrapper<Compensation> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("COMPENSATION_ID","COMPENSATION_NAME");
        queryWrapper.eq("IS_DELETED",0);
        return compensationMapper.selectMaps(queryWrapper);
    }

    //根据id查询薪酬组数据
    @Override
    public Compensation selectCompensationById(Long id) {
        return compensationMapper.selectById(id);
    }
}
