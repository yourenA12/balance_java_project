package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审批流明细表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
public interface AuditflowdetailService extends IService<Auditflowdetail> {
    //修改明细表状态
    int updateAuditflowdetail(Auditflowdetail auditflowdetail);
}
