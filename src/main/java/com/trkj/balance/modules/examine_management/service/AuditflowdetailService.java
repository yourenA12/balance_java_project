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
    //修改 异动 和部门状态
    int updateTransfer(Auditflowdetail auditflowdetail);
    //修改 调薪 工资 状态
    int updateFixedwage(Auditflowdetail auditflowdetail);

    //修改加班表状态
    int updateOvertimeask(Auditflowdetail auditflowdetail);
    //修改补打卡
    int updateCard(Auditflowdetail auditflowdetail);
}
