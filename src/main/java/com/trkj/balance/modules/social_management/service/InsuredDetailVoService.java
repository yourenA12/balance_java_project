package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;

import java.util.List;

public interface InsuredDetailVoService extends IService<InsuredDetailVo> {

    // 查询社保缴费明细
    List<InsuredDetailVo> selectInsuredDetail();
}
