package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Salary;
import com.trkj.balance.modules.examine_management.entity.Travel;
import com.trkj.balance.modules.examine_management.service.SalaryEService;
import com.trkj.balance.modules.examine_management.service.TravelExService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 调薪表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-02-25
 */
@RestController
@Slf4j
public class SalaryEController {
    //添加方法
    @Autowired
    private SalaryEService salaryEService;
    @PostMapping("/SalaryInsert")
    public AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {
        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        List<Auditflowdetail> auditflowdetails = JSON.parseArray(JSON.toJSONString(map.get("AuditflowDetail")), Auditflowdetail.class);
        Salary salary = JSON.parseObject(JSON.toJSONString(map.get("salary")), Salary.class);

      /*  log.debug("222222222");
        log.debug(salary.toString());*/

        return AjaxResponse.success(salaryEService.insertStaff(auditflow,auditflowdetails,salary));
    }
}

