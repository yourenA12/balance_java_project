package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.TravelNVoMapper;
import com.trkj.balance.modules.examine_management.service.travelNVoService;
import com.trkj.balance.modules.examine_management.vo.travelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TravelNVoServiceImpl extends ServiceImpl<TravelNVoMapper, travelVo> implements travelNVoService {
    @Autowired
    //注入mapper
    private TravelNVoMapper travelVoMapper;
    //查询出差表详情
    @Override
    public List<travelVo> findSelectTravelVoById(Long id) {
        return travelVoMapper.findSelectTravelVoById(id);
    }
}
