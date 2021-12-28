package com.trkj.balance.modules.login.controller;


import com.trkj.balance.modules.login.entity.Staff;
import com.trkj.balance.modules.login.service.StaffService;
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
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/tyui")
    public List<Staff> list(){
        return staffService.list();
    }

}

