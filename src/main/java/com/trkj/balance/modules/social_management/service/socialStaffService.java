package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.vo.socialStaffVo;

import java.util.ArrayList;

public interface socialStaffService extends IService<socialStaffVo> {

    //查询全部员工
    IPage<socialStaffVo> selectSocialPage(IPage<socialStaffVo> page, String staffNameSearch, ArrayList deptIds,String stateSearch);
}
