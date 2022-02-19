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
    @Autowired
    private AuditflowdetailService auditflowdetailService;
    @PutMapping("/updateAuditflowdetail")
    public AjaxResponse updateAudiflowdetail(@RequestBody Auditflowdetail auditflowdetail){
        return AjaxResponse.success(auditflowdetailService.updateAuditflowdetail(auditflowdetail));
    }

}

