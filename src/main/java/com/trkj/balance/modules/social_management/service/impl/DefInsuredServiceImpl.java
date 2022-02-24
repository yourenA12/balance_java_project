package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.mapper.DeptPostMapper;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.trkj.balance.modules.social_management.entity.DefScheme;
import com.trkj.balance.modules.social_management.entity.InsuredDeptPost;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.DefInsuredMapper;
import com.trkj.balance.modules.social_management.mapper.DefSchemeMapper;
import com.trkj.balance.modules.social_management.mapper.InsuredDeptPostMapper;
import com.trkj.balance.modules.social_management.mapper.InsuredStaffMapper;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 默认参保方案表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
@Service
public class DefInsuredServiceImpl extends ServiceImpl<DefInsuredMapper, DefInsured> implements DefInsuredService {

    // 默认参保方案
    @Autowired
    private DefInsuredMapper defInsuredMapper;

    // 默认方案
    @Autowired
    private DefSchemeMapper defSchemeMapper;

    // 参保方案 部门职位
    @Autowired
    private InsuredDeptPostMapper insuredDeptPostMapper;

    // 参保方案 员工
    @Autowired
    private InsuredStaffMapper insuredStaffMapper;

    //部门职位表
    @Autowired
    private DeptPostMapper deptPostMapper;

    // 查询所有参保方案
    @Override
    public IPage<DefInsured> selectAllPage(Page page, String name, Object state) {
        QueryWrapper queryWrapper= new QueryWrapper<>();
        if(name!=null && name!=""){
            queryWrapper.like("DEF_INSURED_NAME",name);
        }
        if( state!=null && state!=""){
            queryWrapper.eq("DEF_INSURED_STATE",state);
        }

        return defInsuredMapper.selectPage(page,queryWrapper);
    }

    // 删除参保方案
    @Override
    @Transactional
    public int deleteDefInsured(Long id) {
        return 0;
    }

    // 修改参保方案状态
    @Override
    @Transactional
    public int updateDefInsuredState(DefInsured defInsured) {
        return defInsuredMapper.updateById(defInsured);
    }

    // 新增参保方案状态
    @Override
    @Transactional
    public int insertDefInsured(DefInsured defInsured, List<DefScheme> defScheme,
                                int upper, int lower, ArrayList<Integer> deptIds,
                                ArrayList<Integer> postIds,ArrayList<Integer> staffIds) {

        // 新增参保方案
        if (defInsuredMapper.insert(defInsured)>0){

            // 循环添加方案表
            for (DefScheme defScheme1 : defScheme) {

                //将新加的参保方案id 作为方案表的外键
                defScheme1.setDefInsuredId(defInsured.getDefInsuredId());
                defScheme1.setDefSchemeMin((long) lower);// 下限
                defScheme1.setDefSchemeMax((long) upper);// 上限

                // 添加方案表
                if(defSchemeMapper.insert(defScheme1)<1){
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
                
            }

            // 声明一个 方案 实体类
            InsuredDeptPost insuredDeptPost = new InsuredDeptPost();
            //将新加的参保方案id 作为参保方案部门职位表的外键
            insuredDeptPost.setDefInsuredId(defInsured.getDefInsuredId());

            // 使用双层for循环 按部门id和职位偶读查询部门职位中间表的id
            for (int i=0;i<deptIds.size();i++){ // 循环部门id
                for (int j=0;j<postIds.size();j++){ // 循环职位id
                    // 拿到部门id和职位id 去查询部门职位中间表的id
                    Long deptPostId=deptPostMapper.selectDeptPost(deptIds.get(i),postIds.get(j));
                    // 如果id为空 则 换下一个id继续查询
                    if(deptPostId==null){
                        continue; // 结束此次循环，j++ 再次循环
                    }
                    // 将查询出来的部门职位中间表id，加入参保方案部门职位中间表中
                    insuredDeptPost.setDeptPostId(deptPostId);
                    //添加参保方案部门职位中间表
                    if(insuredDeptPostMapper.insert(insuredDeptPost)<1){
                        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                        // 手动回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return 0;
                    }
                }
            }

            // 声明一个 方案 实体类
            InsuredStaff insuredStaff = new InsuredStaff();
            //将新加的参保方案id 作为参保方案员工表的外键
            insuredStaff.setDefInsuredId(defInsured.getDefInsuredId());

            for (Integer staffId : staffIds) {
                insuredStaff.setStaffId(Long.valueOf(staffId));//将id放入
                // 添加参保方案员工中间表
                if(insuredStaffMapper.insert(insuredStaff)<1){
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }

            int i =9/0;
            return 1;

        }

        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }

    // 按参保方案id查询参保方案
    @Override
    public DefInsured selectDefInsuredById(Long id) {
        return defInsuredMapper.selectById(id);
    }

    // 按参保方案id查询方案
    @Override
    public List<DefScheme> selectDefSchemeById(Long id) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("DEF_INSURED_ID",id);
        return defSchemeMapper.selectList(wrapper);
    }

    // 按参保方案id查询部门id
    @Override
    public List<Integer> selectDeptId(Long id) {
        List<Integer> insuredDeptPosts = insuredDeptPostMapper.selectinsuredDeptPostBydefInsuredId(id);

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("DEPT_POST_ID",insuredDeptPosts);
        return deptPostMapper.selectDeptId(wrapper);
    }

    // 按参保方案id查询职位id
    @Override
    public List<Integer> selectPostId(Long id) {
        List<Integer> insuredDeptPosts = insuredDeptPostMapper.selectinsuredDeptPostBydefInsuredId(id);

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("DEPT_POST_ID",insuredDeptPosts);
        return deptPostMapper.selectPostId(wrapper);
    }

    // 按参保方案id查询员工
    @Override
    public List<Integer> selectStaffId(Long id) {

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STAFF_ID").eq("DEF_INSURED_ID",id);
        return insuredStaffMapper.selectList(wrapper);
    }

    // 按参保方案id删除
    @Override
    public int deleteById(Long id) {

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("DEF_INSURED_ID",id);

        defInsuredMapper.delete(wrapper);
        defSchemeMapper.delete(wrapper);
        insuredDeptPostMapper.delete(wrapper);
        insuredStaffMapper.delete(wrapper);

        return 1;
    }


}
