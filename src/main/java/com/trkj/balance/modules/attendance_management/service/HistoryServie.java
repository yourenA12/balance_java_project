package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.trkj.balance.modules.attendance_management.vo.HistoryVo;

public interface HistoryServie extends IService<Archive> {

    //
    IPage<Archive> selectHis (Page<Archive>page);
}
