package com.trkj.balance.modules.examine_management.service.impl;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Transfer;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.mapper.TransferMapper1;
import com.trkj.balance.modules.examine_management.service.TransferService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 调动记录表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-08
 */
@Service
public class TransferServiceImpl1 extends ServiceImpl<TransferMapper1, Transfer> implements TransferService1 {
    //注入审批主表mapper
    @Autowired
    private AuditflowMapper auditflowMapper;
    //注入审批明细表mapper
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    //注入调动记录表mapper
    @Autowired
    private TransferMapper1 transferMapper1;


    @Override
    @Transactional
    public int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Transfer transfer) {
        //添加审批主表
        if(auditflowMapper.insert(auditflow)>0){
            //插入主表数据
            transfer.setAuditflowId(auditflow.getAuditflowId());
            if(transferMapper1.insert(transfer) > 0){

                // 声明一个审批明细表实体类
                Auditflowdetail auditflowdetail = new Auditflowdetail();

                //审批明细表插入主表id
                auditflowdetail.setAuditflowId(auditflow.getAuditflowId());

                for (int i =0;i< auditflowdetails.size();i++){

                    auditflowdetail.setStaffId(auditflowdetails.get(i).getStaffId());

                    auditflowdetail.setStaffName(auditflowdetails.get(i).getStaffName());
                    if(i==0){
                        auditflowdetail.setAuditflowdetaiState(1L);
                        auditflowdetail.setAuditflowdetaiRemarks("待我审批");
                    }else{
                        auditflowdetail.setAuditflowdetaiState(0L);
                        auditflowdetail.setAuditflowdetaiRemarks("待审批");
                    }
                    //明细表插入成功
                    auditflowdetailMapper.insert(auditflowdetail);

                }
                return 1;
            };
        }
        return 0;
    }
}
