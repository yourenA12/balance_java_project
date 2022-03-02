package com.trkj.balance.modules.examine_management.controller;


import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.service.AuditflowdetailService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 审批流明细表 前端控制器
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/auditflowdetail")
public class AuditflowdetailController {
    //修改
    @Autowired
    private AuditflowdetailService auditflowdetailService;

    @PutMapping("/updateAuditflowdetail")
    public AjaxResponse updateAudiflowdetail(@RequestBody Auditflowdetail auditflowdetail){
        return AjaxResponse.success(auditflowdetailService.updateAuditflowdetail(auditflowdetail));
    }
    //修改调薪表
    @PutMapping("/updateSalary")
    public AjaxResponse updateSalary(@RequestBody Auditflowdetail auditflowdetail){
        return AjaxResponse.success(auditflowdetailService.updateFixedwage(auditflowdetail));
    }
    //修改 加班表
    @PutMapping("/updateOvertimeask")
    public AjaxResponse updateOvertimeask(@RequestBody Auditflowdetail auditflowdetail){
        return AjaxResponse.success(auditflowdetailService.updateOvertimeask(auditflowdetail));
    }
    //修改 异动（调动表）
    @PutMapping("/updateTransfer")
    public AjaxResponse updateTransfer(@RequestBody Auditflowdetail auditflowdetail){
        return AjaxResponse.success(auditflowdetailService.updateTransfer(auditflowdetail));
    }
    //修改 补打卡
    @PutMapping("/updateCard")
    public AjaxResponse updateCard(@RequestBody Auditflowdetail auditflowdetail){
        return AjaxResponse.success(auditflowdetailService.updateCard(auditflowdetail));
    }
}

