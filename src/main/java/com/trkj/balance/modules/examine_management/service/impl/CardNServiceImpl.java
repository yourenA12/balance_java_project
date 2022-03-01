package com.trkj.balance.modules.examine_management.service.impl;

import com.trkj.balance.modules.attendance_management.mapper.CardMapper;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Card;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.mapper.CardNMapper;
import com.trkj.balance.modules.examine_management.service.CardNService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 补打卡表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
@Service
public class CardNServiceImpl extends ServiceImpl<CardNMapper, Card> implements CardNService {


    //补打卡添加
    @Autowired
    private CardNMapper cardNMapper;

    @Autowired
    private  AuditflowMapper auditflowMapper;

    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;

    @Override
    @Transactional
    public int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Card card) {
        //添加审批主表
        if(auditflowMapper.insert(auditflow)>0){
            //插入主表数据
            card.setAuditflowId(auditflow.getAuditflowId());
            if(cardNMapper.insert(card) > 0){

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
