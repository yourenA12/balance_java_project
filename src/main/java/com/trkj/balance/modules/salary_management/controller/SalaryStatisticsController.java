package com.trkj.balance.modules.salary_management.controller;

import com.trkj.balance.modules.salary_management.service.SsalaryStatisticsService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 薪酬统计
@Slf4j
@RestController
@RequestMapping("/salaryStatistics")
public class SalaryStatisticsController {

    // 薪酬统计
    @Autowired
    private SsalaryStatisticsService statisticsService;

    // 每个月的缴费
    @GetMapping("/salaryStatistics")
    public AjaxResponse salaryStatistics(){
        return AjaxResponse.success(statisticsService.salaryStatistics());
    }

    //查询工资已归档
    @GetMapping("/selectWagenotfiledVo/{date}")
    public AjaxResponse selectWagenotfiledVo(@PathVariable("date") String date){
        return AjaxResponse.success(statisticsService.selectWagenotfiledVo(date));
    }

}
