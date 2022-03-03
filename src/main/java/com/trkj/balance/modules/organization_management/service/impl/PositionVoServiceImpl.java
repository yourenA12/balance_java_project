package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.organization_management.mapper.PositionsVoMapper;
import com.trkj.balance.modules.organization_management.service.PositionVoService;
import com.trkj.balance.modules.organization_management.vo.PositionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class PositionVoServiceImpl extends ServiceImpl<PositionsVoMapper, PositionVo> implements PositionVoService {

    @Autowired
    public PositionsVoMapper positionsVoMapper;


}
