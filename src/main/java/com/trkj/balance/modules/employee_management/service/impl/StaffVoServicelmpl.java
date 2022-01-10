package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.trkj.balance.modules.employee_management.mapper.EntryhirdeVoMapper;
import com.trkj.balance.modules.employee_management.mapper.StaffVoMapper;
import com.trkj.balance.modules.employee_management.service.EntryhirdeVoService;
import com.trkj.balance.modules.employee_management.service.StaffVoService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffVoServicelmpl extends ServiceImpl<StaffVoMapper, StaffVo> implements StaffVoService {
   @Autowired
   private StaffVoMapper staffVoMapper;

    @Override
    public IPage<StaffVo> selectStaffVo(Page<StaffVo> page) {
        return staffVoMapper.selectStaffVo(page);
    }

    @Override
    public StaffVo selectStaffId(Long id) {
        return staffVoMapper.selectStaffId(id);
    }

    @Override
    public IPage<StaffVo> selectProbation(Page<StaffVo> page) {
        return staffVoMapper.selectProbation(page);
    }
}
