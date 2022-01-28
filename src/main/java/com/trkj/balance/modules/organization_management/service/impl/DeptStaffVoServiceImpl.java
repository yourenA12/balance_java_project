package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.organization_management.mapper.DeptStaffVoMapper;
import com.trkj.balance.modules.organization_management.service.DeptStaffVoService;
import com.trkj.balance.modules.organization_management.vo.DeptStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptStaffVoServiceImpl extends ServiceImpl<DeptStaffVoMapper, DeptStaffVo> implements DeptStaffVoService {

    @Autowired
    public DeptStaffVoMapper deptStaffVoMapper;

    // 按部门id 查询员工数据
    @Override
    public IPage<DeptStaffVo> selectDeptygVo(Page<DeptStaffVo> page) {
        return null;
    }
}
