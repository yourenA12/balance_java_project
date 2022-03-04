package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.vo.InsuredMonthVo;

import java.util.List;

public interface InsuredMonthVoService extends IService<InsuredMonthVo> {

    //查询社保月度报表
    List<InsuredMonthVo> selectInsuredMonthVo();
}
