package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.employee_management.entity.Resume;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Worker;
import com.trkj.balance.modules.examine_management.service.AuditflowService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 审批主表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@RestController
@Slf4j
public class AuditflowController {
    //添加方法
    @Autowired
    private AuditflowService auditflowService;
    @PostMapping("/insertStaff")
    private AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {

        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        Auditflowdetail auditflowdetail = JSON.parseObject(JSON.toJSONString(map.get("Auditflowdetail")), Auditflowdetail.class);
        Worker worker = JSON.parseObject(JSON.toJSONString(map.get("Worker")), Worker.class);
        //调用入职方法，
        return AjaxResponse.success(auditflowService.insertStaff(auditflow,auditflowdetail,worker));
    }
}


