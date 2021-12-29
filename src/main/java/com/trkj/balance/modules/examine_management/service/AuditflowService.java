package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审批主表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
public interface AuditflowService extends IService<Auditflow> {
    IPage<Auditflow> findSelect(Page<Auditflow> page);
}
