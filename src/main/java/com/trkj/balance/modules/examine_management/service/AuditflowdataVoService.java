package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.AuditflowdataVo;
/*
* 审批明细表与审批主表的
* */
public interface AuditflowdataVoService extends IService<AuditflowdataVo> {
    IPage<AuditflowdataVo> findSelectPage(Page<AuditflowdataVo> page);
}
