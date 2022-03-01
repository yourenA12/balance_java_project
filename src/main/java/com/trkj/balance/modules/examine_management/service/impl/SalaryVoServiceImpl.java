package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.SalaryVoMapper;
import com.trkj.balance.modules.examine_management.service.SalaryVoService;
import com.trkj.balance.modules.examine_management.vo.SalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaryVoServiceImpl extends ServiceImpl<SalaryVoMapper, SalaryVo> implements SalaryVoService {
    //注入mapper
    @Autowired
    private SalaryVoMapper salaryVoMapper;

    @Override
    public List<SalaryVo> findSelectSalaryById(Long id) {
        return salaryVoMapper.finSelectSalarById(id);
    }
}
