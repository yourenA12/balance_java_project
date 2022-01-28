package com.trkj.balance.modules.organization_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.organization_management.vo.DeptStaffVo;

public interface DeptStaffVoService extends IService<DeptStaffVo> {

    //查询部门负责人的信息
    IPage<DeptStaffVo> selectDeptygVo(Page<DeptStaffVo> page);
}
