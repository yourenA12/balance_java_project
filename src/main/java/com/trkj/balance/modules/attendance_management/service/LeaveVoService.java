package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.attendance_management.vo.LeaveVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LeaveVoService extends IService<LeaveVo> {

    //模糊分页查询
    IPage<LeaveVo> selsectLeave (int page, int size, String staffName, Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd);

    //查询所有部门
    List<Map<Object,Object>> selectDept();
}
