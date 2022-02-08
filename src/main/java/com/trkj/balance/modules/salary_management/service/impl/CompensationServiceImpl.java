package com.trkj.balance.modules.salary_management.service.impl;

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
    public int insertCompensation(Compensation compensation, CompensationDeptPost compensationDeptPost) {
       //添加薪酬组
        if(compensationMapper.insert(compensation)>0){

            //将新加的薪酬组id 作为薪酬组部门职位表的外键
            compensationDeptPost.setCompensationId(compensation.getCompensationId());
            //添加薪酬组部门职位表
            if(compensationDeptPostMapper.insert(compensationDeptPost)>0){
                return 0;
            }
        }

        return 0;
    }
}
