package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.employee_management.entity.Position;
import com.trkj.balance.modules.employee_management.mapper.PositionMapper;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;
import com.trkj.balance.modules.salary_management.entity.Dept;
import com.trkj.balance.modules.salary_management.mapper.DeptPostMapper;
import com.trkj.balance.modules.salary_management.mapper.DeptSalaryMapper;
import com.trkj.balance.modules.social_management.entity.InsuredDeptPost;
import com.trkj.balance.modules.social_management.mapper.InsuredDeptPostMapper;
import com.trkj.balance.modules.social_management.service.InsuredDeptPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 参保方案部门职位中间表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
@Service
public class InsuredDeptPostServiceImpl extends ServiceImpl<InsuredDeptPostMapper, InsuredDeptPost> implements InsuredDeptPostService {

    @Autowired
    private InsuredDeptPostMapper insuredDeptPostMapper;

    @Autowired
    private DeptPostMapper deptPostMapper;

    @Autowired
    private DeptSalaryMapper deptMapper;

    @Autowired
    private PositionMapper postMapper;

    // 按部门id和职位id查询 部门 、 职位ids
    @Override
    public String selectInsuredDeptPost(List<Integer> deptIds, List<Integer> postIds) {

        String a = "";

        // 使用双层for循环 按部门id和职位偶读查询部门职位中间表的id
        for (int i=0;i<deptIds.size();i++){ // 循环部门id
            for (int j=0;j<postIds.size();j++){ // 循环职位id
                // 拿到部门id和职位id 去查询部门职位中间表的id
                Long deptPostId=deptPostMapper.selectDeptPost(deptIds.get(i),postIds.get(j));
                // 如果id为空 则 换下一个id继续查询
                if(deptPostId==null){
                    continue; // 结束此次循环，j++ 再次循环
                }
                // 声明一个条件构造器
                QueryWrapper<InsuredDeptPost> wrapper = new QueryWrapper<>();
                wrapper.eq("DEPT_POST_ID",deptPostId);
                if(insuredDeptPostMapper.selectCount(wrapper)>0){

                    // 按照职位id 查询职位名称
                    QueryWrapper wrapper1 = new QueryWrapper();
                    wrapper1.select("POSITION_NAME").eq("POSITION_ID",postIds.get(i));
                    Position post = postMapper.selectOne(wrapper1);
                    // 将职位名称拼接上
                    a+=post.getPositionName();

                    // 将部门id 定义为 x
                    int x = deptIds.get(i);

                    // 定义死循环
                    while (true){
                        // 按照部门id 查询部门名称 及 上级部门id
                        QueryWrapper wrapper2 = new QueryWrapper();
                        wrapper2.eq("DEPT_ID",x);
                        Dept dept = deptMapper.selectOne(wrapper2);
                        // 部门名称 拼接上 数组
                        a=dept.getDeptName()+"-"+a;

                        log.error("1111111111111111111");
                        log.error(x+"");
                        log.error(dept.toString());
                        log.error(deptMapper.selectOne(wrapper2).toString());

                        // 如果为最上级部门
                        if( dept.getDeptPid() <1 ){
                            // 返回 拼接后的字符串
                            return a;
                        }
                        // 当前部门不为 最上级部门，则定义x为部门id 继续查询上级部门名称
                        x= Math.toIntExact(dept.getDeptPid());

                    }

                }

            }
        }

        return null;
    }

}
