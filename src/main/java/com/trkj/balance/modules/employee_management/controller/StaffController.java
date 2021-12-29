package com.trkj.balance.modules.employee_management.controller;


import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("tyui")
    private List<Staff> list(){
        return staffService.list();
    }

}

