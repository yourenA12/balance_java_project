package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;

import java.util.List;

// 薪酬统计
public interface SsalaryStatisticsService extends IService<com.trkj.balance.modules.salary_management.vo.salaryStatisticsVo> {

    // 薪酬统计
    List<com.trkj.balance.modules.salary_management.vo.salaryStatisticsVo> salaryStatistics();

    //查询工资已归档
    List<WagenotfiledVo> selectWagenotfiledVo(String date);

}
