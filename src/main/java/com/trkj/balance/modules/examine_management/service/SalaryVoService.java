package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.Salary;
import com.trkj.balance.modules.examine_management.vo.SalaryVo;

import java.util.List;

public interface SalaryVoService extends IService<SalaryVo> {
    List<SalaryVo> findSelectSalaryById(Long id);
}
