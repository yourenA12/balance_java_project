package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.CardVoNMapper;
import com.trkj.balance.modules.examine_management.service.CardVoNService;
import com.trkj.balance.modules.examine_management.vo.CardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardVoNServiceImpl extends ServiceImpl<CardVoNMapper, CardVo> implements CardVoNService {
    //注入mapper
    //通过id 查询补打卡详情
    @Autowired
    private CardVoNMapper cardVoMapper;

    @Override
    public List<CardVo> findSelectCardById(Long id) {
        return cardVoMapper.findSelectCardById(id);
    }
}
