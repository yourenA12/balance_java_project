package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.Vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.Salary;
import com.trkj.balance.modules.salary_management.mapper.SalaryFixedMapper;
import com.trkj.balance.modules.salary_management.mapper.WageVoMapper;
import com.trkj.balance.modules.salary_management.service.SalaryFixedService;
import com.trkj.balance.modules.salary_management.service.WageVoService;
import org.springframework.stereotype.Service;

@Service
public class WageVoServicelmpl extends ServiceImpl<WageVoMapper, WagVo> implements WageVoService {
}
