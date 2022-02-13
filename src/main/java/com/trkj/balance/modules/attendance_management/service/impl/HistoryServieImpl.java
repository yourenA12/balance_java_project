package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.trkj.balance.modules.attendance_management.mapper.HistoryVoMapper;
import com.trkj.balance.modules.attendance_management.service.HistoryServie;
import com.trkj.balance.modules.attendance_management.vo.HistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServieImpl extends ServiceImpl<HistoryVoMapper, Archive> implements HistoryServie {

    @Autowired
    public HistoryVoMapper historyVoMapper;

    @Override
    public IPage<Archive> selectHis(Page<Archive> page) {
        return historyVoMapper.selectPage(page,null);
    }
}
