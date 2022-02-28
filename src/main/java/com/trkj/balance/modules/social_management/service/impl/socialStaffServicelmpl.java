package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.InsuredStaffMapper;
import com.trkj.balance.modules.social_management.mapper.socialStaffMapper;
import com.trkj.balance.modules.social_management.service.InsuredStaffService;
import com.trkj.balance.modules.social_management.service.socialStaffService;
import com.trkj.balance.modules.social_management.vo.socialStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class socialStaffServicelmpl extends ServiceImpl<socialStaffMapper, socialStaffVo> implements socialStaffService {
    @Autowired
    private socialStaffMapper socialStaffMapper;

    //查询全部员工
    @Override
    public IPage<socialStaffVo> selectSocialPage(IPage<socialStaffVo> page,String staffNameSearch, ArrayList deptIds,String stateSearch) {
        QueryWrapper<socialStaffVo> wrapper=new QueryWrapper();

        if(staffNameSearch!="" && staffNameSearch!=null ){
            // 按员工名称进行模糊查询
            wrapper.like("s.STAFF_NAME",staffNameSearch);
        }

        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }

        if(stateSearch!="" && stateSearch!=null){
            // 按员工状态
            wrapper.eq("s.STAFF_STATE",stateSearch);
        }

        wrapper.ne("STAFF_STATE",1);
        return socialStaffMapper.selectSocialPage(page,wrapper);
    }


}
