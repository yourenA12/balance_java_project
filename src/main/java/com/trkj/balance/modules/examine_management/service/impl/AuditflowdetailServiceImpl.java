package com.trkj.balance.modules.examine_management.service.impl;

import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.service.AuditflowdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批流明细表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@Service
public class AuditflowdetailServiceImpl extends ServiceImpl<AuditflowdetailMapper, Auditflowdetail> implements AuditflowdetailService {
    //修改审批明细表的状态
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    @Override
    public int updateAuditflowdetail(Auditflowdetail auditflowdetail) {
        return auditflowdetailMapper.updateById(auditflowdetail);
    }
}
