package com.trkj.balance.modules.examine_management.service.impl;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Leave;
import com.trkj.balance.modules.examine_management.mapper.AuditflowMapper;
import com.trkj.balance.modules.examine_management.mapper.AuditflowdetailMapper;
import com.trkj.balance.modules.examine_management.mapper.LeavenMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.service.LeavenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 请假表 服务实现类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-19
 */
@Service
public class LeavenServiceImpl extends ServiceImpl<LeavenMapper, Leave> implements LeavenService {
    //审批主表的mapper
    @Autowired
    private AuditflowMapper auditflowMapper;
    //注入审批明细表
    @Autowired
    private AuditflowdetailMapper auditflowdetailMapper;
    //注入 请假表mapper
    @Autowired
    private LeavenMapper leavenMapper;

    @Override
    @Transactional//事务注解 报错回滚
    public int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Leave leave) {
        //添加审批主表
        if(auditflowMapper.insert(auditflow)>0){
            //插入主表数据
            leave.setAuditflowId(auditflow.getAuditflowId());
            if(leavenMapper.insert(leave) > 0){

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
