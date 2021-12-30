package com.trkj.balance.modules.employee_management.controller;


import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.service.StaffService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

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

    @PostMapping("/insertStaff")
    private AjaxResponse insertStaff(@RequestBody Staff staff){
        int staff1 = staffService.insertStaff(staff);
        return AjaxResponse.success(staff1);
    }

}

