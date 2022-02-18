package com.trkj.balance.modules.employee_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.employee_management.service.Quit_StaffService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Queue;

/**
 * <p>
 * 离职表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-01-08
 */
@Slf4j
@RestController
@RequestMapping("/quit_Staff")
public class Quit_StaffController {

    @Autowired
    private Quit_StaffService quit_staffService;

     //员工办理离职 添加离职表和修改员工状态
    @PostMapping("/insertquit_staff")
    private AjaxResponse insertquit_staff(@RequestBody Map<Object, Object> map) {

        Quit quit = JSON.parseObject(JSON.toJSONString(map.get("Quit")), Quit.class);
        Staff staff = JSON.parseObject(JSON.toJSONString(map.get("Staff")), Staff.class); // 取map中的 员工表数据 转换为实体类

        log.debug( quit.toString() + "1111" );
        log.debug( staff.toString() + "1111" );


        //调用离职方法，
        return AjaxResponse.success(quit_staffService.insertDimission(quit,staff));
    }

}

