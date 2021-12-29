package com.trkj.balance.modules.examine_management.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.service.AuditflowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private AuditflowService auditflowService;

    @GetMapping("/findSelect")
    public Page<Auditflow> findSelect(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        Page<Auditflow> page= new Page<>(currentPage-1,pagesize);
        Page<Auditflow> page1 = (Page<Auditflow>) auditflowService.findSelect(page);
        return page1;
    }
}


