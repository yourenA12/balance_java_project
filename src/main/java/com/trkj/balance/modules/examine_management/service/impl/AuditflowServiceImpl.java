package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.service.AuditflowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批主表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@Service
public class AuditflowServiceImpl extends ServiceImpl<AuditflowMapper, Auditflow> implements AuditflowService {
    @Autowired
    private AuditflowMapper auditflowMapper;
    @Override
    public IPage<Auditflow> findSelect(Page<Auditflow> page) {
        return auditflowMapper.selectPage(page,null);
    }
}
