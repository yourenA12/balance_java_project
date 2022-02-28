package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.social_management.vo.SocialStaffVo;

import java.util.ArrayList;

public interface SocialStaffService extends IService<SocialStaffVo> {

    // 查询全部员工
    IPage<SocialStaffVo> selectSocialPage(IPage<SocialStaffVo> page, String staffNameSearch, ArrayList deptIds, String stateSearch);

    // 添加参保方案员工表
//    int insertInsuredStaff(int insuredId,ArrayList staffIds);

}
