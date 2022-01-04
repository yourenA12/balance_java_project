package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.vo.StaffVo;


public interface StaffVoService extends IService<StaffVo> {
    //查询员工信息
    IPage<StaffVo> selectStaffVo (Page<StaffVo> page);
}
