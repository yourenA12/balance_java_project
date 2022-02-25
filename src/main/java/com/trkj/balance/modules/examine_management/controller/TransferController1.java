package com.trkj.balance.modules.examine_management.controller;


import com.alibaba.fastjson.JSON;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Transfer;
import com.trkj.balance.modules.examine_management.service.TransferService1;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 调动记录表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2022-02-08
 */
@RestController
@Slf4j
public class TransferController1 {
    //异动添加方法
    @Autowired
    private TransferService1 transferService1;

    @PostMapping("/insertTransefer")
    public AjaxResponse insertStaff(@RequestBody Map<Object, Object> map) {
        Auditflow auditflow = JSON.parseObject(JSON.toJSONString(map.get("Auditflow")), Auditflow.class); // 取map中的 员工表数据 转换为实体类
        List<Auditflowdetail> auditflowdetails = JSON.parseArray(JSON.toJSONString(map.get("AuditflowDetail")), Auditflowdetail.class);
        Transfer transfer = JSON.parseObject(JSON.toJSONString(map.get("Transfer")), Transfer.class);

        log.error("1111111111111");
        log.error(auditflow.toString());
        log.error(auditflowdetails.toString());
        log.error(transfer.toString());

        return AjaxResponse.success(transferService1.insertStaff(auditflow,auditflowdetails,transfer));
    }

}

