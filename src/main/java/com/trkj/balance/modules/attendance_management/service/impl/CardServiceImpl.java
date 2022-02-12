package com.trkj.balance.modules.attendance_management.service.impl;

import com.trkj.balance.modules.attendance_management.entity.Card;
import com.trkj.balance.modules.attendance_management.mapper.CardMapper;
import com.trkj.balance.modules.attendance_management.service.CardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 补打卡表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-05
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {
    @Autowired
    public CardMapper cardMapper;

    @Override
    public int Carddelete(Long id) {
        return cardMapper.deleteById(id);
    }
}
