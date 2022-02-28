package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.mapper.InsuredDetailVoMapper;
import com.trkj.balance.modules.social_management.service.InsuredDetailVoService;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuredDetailVoServiceImpl  extends ServiceImpl<InsuredDetailVoMapper, InsuredDetailVo> implements InsuredDetailVoService {

    @Autowired
    private InsuredDetailVoMapper detailVoMapper;

    // 查询社保缴费明细
    @Override
    public List<InsuredDetailVo> selectInsuredDetail() {

        return detailVoMapper.selectInsuredDetail();
    }
}
