package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Overtimeask;
import com.trkj.balance.modules.examine_management.service.OvertimeaskNService;
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
 * 加班表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
@RestController
@Slf4j
public class OvertimeaskNController {
    //注入service
    @Autowired
    private OvertimeaskNService overtimeaskNService;
    //添加方法
    @PostMapping("/insertOver")
    public AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {
        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        List<Auditflowdetail> auditflowdetails = JSON.parseArray(JSON.toJSONString(map.get("AuditflowDetail")), Auditflowdetail.class);
        Overtimeask overtimeask = JSON.parseObject(JSON.toJSONString(map.get("overtimeask")), Overtimeask.class);


        return AjaxResponse.success(overtimeaskNService.insertStaff(auditflow,auditflowdetails,overtimeask));
    }
}

