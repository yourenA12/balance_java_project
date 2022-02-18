package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.attendance_management.vo.CardVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CardVoService extends IService<CardVo> {
    //
    IPage<CardVo> selectCart(int page, int size, String staffName, Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd);

    //查询全部部门
    List<Map<Object,Object>> dept();
}
