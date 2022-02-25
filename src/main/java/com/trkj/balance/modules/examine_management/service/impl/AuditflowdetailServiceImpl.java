package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.service.AuditflowdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private AuditflowMapper auditflowMapper;

    @Override
    @Transactional
    public int updateAuditflowdetail(Auditflowdetail auditflowdetail) {

        // 按照明细表id更改状态为
        auditflowdetailMapper.updateById(auditflowdetail);

        if (auditflowdetail.getAuditflowdetaiState()==2){
            // 按照主表id查询明细表数据,
            Page<Auditflowdetail> page = new Page<>(1,1);
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.select("AUDITFLOWDETAIL_ID").eq("AUDITFLOW_ID",auditflowdetail.getAuditflowId());
            wrapper.eq("AUDITFLOWDETAI_STATE",0);
            wrapper.orderByAsc("CREATED_TIME");
            IPage a = auditflowdetailMapper.selectPage(page,wrapper);

            // 获取第一条数据改状态为1
            if (a.getTotal()>0){
                Auditflowdetail auditflowdetail1=(Auditflowdetail)a.getRecords().get(0);
                Auditflowdetail auditflowdetail2= new Auditflowdetail();
                auditflowdetail2.setAuditflowdetailId(auditflowdetail1.getAuditflowdetailId());
                auditflowdetail2.setAuditflowdetaiState(1L);
                auditflowdetailMapper.updateById(auditflowdetail2);
            }else{// 如果没有就改主表状态为2
                Auditflow auditflow = new Auditflow();
                auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
                auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
                auditflowMapper.updateById(auditflow);
            }
        }else{
            // 按照主表id更改主表状态为3
            Auditflow auditflow = new Auditflow();
            auditflow.setAuditflowId(auditflowdetail.getAuditflowId());
            auditflow.setAuditflowState(auditflowdetail.getAuditflowdetaiState());
            auditflowMapper.updateById(auditflow);
        }

        return 1;
    }
}
