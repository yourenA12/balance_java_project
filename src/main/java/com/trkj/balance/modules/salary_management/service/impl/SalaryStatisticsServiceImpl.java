package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.mapper.SalaryStatisticsMapper;
import com.trkj.balance.modules.salary_management.service.SsalaryStatisticsService;
import com.trkj.balance.modules.salary_management.vo.SalaryStatisticsVo;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 薪酬统计
@Service
public class SalaryStatisticsServiceImpl extends ServiceImpl<SalaryStatisticsMapper, SalaryStatisticsVo> implements SsalaryStatisticsService {

    // 薪酬统计
    @Autowired
    private SalaryStatisticsMapper statisticsMapper;

    // 查询薪酬统计
    @Override
    public List<SalaryStatisticsVo> salaryStatistics() {
        return statisticsMapper.salaryStatistics();
    }

    //查询工资已归档
    @Override
    public List<WagenotfiledVo> selectWagenotfiledVo(String date) {
        return statisticsMapper.selectWagenotfiledVo(date);
    }

}
