package com.trkj.balance.modules.salary_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.employee_management.service.FixedwageService;
import com.trkj.balance.modules.salary_management.entity.Salary;
import com.trkj.balance.modules.salary_management.service.SalaryFixedService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 调薪表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-02-21
 */
@Slf4j
@RestController
@RequestMapping("/salary")
public class SalaryFixedController {

    //调薪表
    @Autowired
    private SalaryFixedService salaryFixedService;


    //添加调薪
    @PostMapping("/insertSalary")
    private AjaxResponse insertSalary(@RequestBody Map<Object, Object> map) {

        Salary salary = JSON.parseObject(JSON.toJSONString(map.get("Salary")), Salary.class); // 取map中的 员工表数据 转换为实体类
        Fixedwage fixedwage = JSON.parseObject(JSON.toJSONString(map.get("Fixedwage")), Fixedwage.class);

        log.debug("!111111111111");
        log.debug(salary.toString());
        log.debug(fixedwage.toString());

        //调用入职方法，
        return AjaxResponse.success(salaryFixedService.insertFixedwage(salary,fixedwage));
    }

    //查询调薪表数据
    @GetMapping("/selectSalary")
    public AjaxResponse selectSalary(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                     @RequestParam("staffName") String staffName){

        Page<Salary> page = new Page<>(currenPage,pagesize);
        IPage<Salary> list=salaryFixedService.selectSalaryPage(page,staffName);
        return AjaxResponse.success(list);

    }

}

