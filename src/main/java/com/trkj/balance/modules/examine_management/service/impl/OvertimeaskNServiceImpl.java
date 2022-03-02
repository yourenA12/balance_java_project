package com.trkj.balance.modules.examine_management.service.impl;

import com.trkj.balance.modules.attendance_management.mapper.OvertimeaskMapper;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Overtimeask;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.mapper.OvertimeaskNMapper;
import com.trkj.balance.modules.examine_management.service.OvertimeaskNService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 加班表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
@Service
public class OvertimeaskNServiceImpl extends ServiceImpl<OvertimeaskNMapper, Overtimeask> implements OvertimeaskNService {

    @Autowired
    private OvertimeaskNMapper overtimeasknMapper;

    @Autowired
    private AuditflowMapper auditflowMapper;

    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    @Transactional
    @Override
    public int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Overtimeask overtimeask) {
        //添加审批主表
        if(auditflowMapper.insert(auditflow)>0){
            //插入主表数据
            overtimeask.setAuditflowId(auditflow.getAuditflowId());
            if(overtimeasknMapper.insert(overtimeask) > 0){

                // 声明一个审批明细表实体类
                Auditflowdetail auditflowdetail = new Auditflowdetail();

                //审批明细表插入主表id
                auditflowdetail.setAuditflowId(auditflow.getAuditflowId());
                //循环往明细表填加三条数据
                for (int i =0;i< auditflowdetails.size();i++){

                    auditflowdetail.setStaffId(auditflowdetails.get(i).getStaffId());

                    auditflowdetail.setStaffName(auditflowdetails.get(i).getStaffName());
                    //如果 第一条数据等于0 就改成1 待我审批的状态 其他的为0
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
