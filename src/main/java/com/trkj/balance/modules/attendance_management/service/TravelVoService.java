package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TravelVoService extends IService<TravelVo> {
    //分页查询
    IPage<TravelVo> selectTravel (int page, int size, String staffName , Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd);

    //查询全部部门
    List<Map<Object,Object>> dept();

}
