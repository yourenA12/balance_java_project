package com.trkj.balance.modules.employee_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.employee_management.service.StaffService;
import com.trkj.balance.modules.employee_management.service.Worker_StaffService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 转正 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
@RestController
@RequestMapping("/worker")
public class Worker_StaffController {
    @Autowired
    private Worker_StaffService worker_staffService;

    @Autowired
    private StaffService staffService;

    //添加员工表
    @PostMapping("/insertWorker")
    private AjaxResponse insertWorker(@RequestBody Map<Object, Object> map) {

        Worker worker = JSON.parseObject(JSON.toJSONString(map.get("Worker")), Worker.class); // 取map中的 员工表数据 转换为实体类
        Staff staff = JSON.parseObject(JSON.toJSONString(map.get("Staff")), Staff.class);

        //调用转正方法，
        return AjaxResponse.success(worker_staffService.insertWorker(worker,staff));
    }

}

