package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Worker;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.mapper.WorkerMapper;
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
    //注入转正表 mapper
    @Autowired
    private WorkerMapper workerMapper;
    //注入审批主表mapper
    @Autowired
    private  AuditflowMapper auditflowMapper;
    //注入审批明细表mapper
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;

    @Override
    public int insertStaff(Auditflow auditflow, Auditflowdetail auditflowdetail, Worker worker) {
        //添加审批主表
       if(auditflowMapper.insert(auditflow)>0){
           //审批明细表插入主表id
           auditflowdetail.setAuditflowId(auditflow.getAuditflowId());
           //明细表插入成功
           if(auditflowdetailMapper.insert(auditflowdetail)>0){
              //就插入主表数据
               worker.setAuditflowId(auditflow.getAuditflowId());

                   return workerMapper.insert(worker);

           }
       }

        return 0;
    }
}
