package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.vo.SalaryStatisticsVo;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 薪酬统计
public interface SsalaryStatisticsService extends IService<SalaryStatisticsVo> {

    // 薪酬统计
    List<SalaryStatisticsVo> salaryStatistics();

    //查询工资已归档
    List<WagenotfiledVo> selectWagenotfiledVo(String date);

}
