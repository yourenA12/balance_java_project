package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.controller.AuditflowdetailController;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdataVoMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.service.AuditflowdataVoService;
import com.trkj.balance.modules.examine_management.service.AuditflowdetailService;
import com.trkj.balance.modules.examine_management.vo.AuditflowdataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class AuditflowdataVoServiceImpl extends ServiceImpl<AuditflowdataVoMapper, AuditflowdataVo> implements AuditflowdataVoService {
    @Autowired
    private AuditflowdataVoMapper auditflowdataVoMapper;
    //分页查询明细表和审批主表
    @Override
    public IPage<AuditflowdataVo> findSelectPage(Page<AuditflowdataVo> page) {
        //调用mapper里的方法
        return auditflowdataVoMapper.findSelectPage(page);
    }

}
