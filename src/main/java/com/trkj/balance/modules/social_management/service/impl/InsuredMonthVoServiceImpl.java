package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.mapper.InsuredMonthVoMapper;
import com.trkj.balance.modules.social_management.mapper.InsuredStaffMapper;
import com.trkj.balance.modules.social_management.service.InsuredMonthVoService;
import com.trkj.balance.modules.social_management.service.InsuredStaffService;
import com.trkj.balance.modules.social_management.vo.InsuredMonthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuredMonthVoServiceImpl extends ServiceImpl<InsuredMonthVoMapper, InsuredMonthVo> implements InsuredMonthVoService {

    @Autowired
    private InsuredMonthVoMapper insuredMonthVoMapper;

    //查询社保月度报表
    @Override
    public List<InsuredMonthVo> selectInsuredMonthVo() {

        return insuredMonthVoMapper.selectInsuredMonthVo();
    }
}
