package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.entity.ClockRecord;
import com.trkj.balance.modules.examine_management.mapper.ClokinssMapper;
import com.trkj.balance.modules.examine_management.service.ClockinssService;
import com.trkj.balance.modules.examine_management.vo.ClockinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClockinssImpl extends ServiceImpl<ClokinssMapper, ClockRecord> implements ClockinssService {

    @Autowired
    public ClokinssMapper clokinssMapper;


    //添加
    @Override
    @Transactional //事务注解
    public int addclock(ClockRecord clockRecord) {
        return clokinssMapper.insert(clockRecord);
    }

    //修改
    @Override
    @Transactional //事务注解
    public int amendclock(ClockRecord clockRecord) {
        return clokinssMapper.updateById(clockRecord);
    }
}
