package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Worker worker) {

        //添加审批主表
       if(auditflowMapper.insert(auditflow)>0){
           //插入主表数据
           worker.setAuditflowId(auditflow.getAuditflowId());
           if(workerMapper.insert(worker) > 0){

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
    //修改主表状态
    @Override
    @Transactional
    public int updateAuditflow(Auditflow auditflow) {
        return auditflowMapper.updateById(auditflow);
    }

    @Override
    public IPage<Auditflow> findSelectId(Page<Auditflow> page,int id) {
        // 声明一个条件构造器
        QueryWrapper<Auditflow> wrapper = new QueryWrapper<>();
        wrapper.eq("STAFF_ID",id);
        return auditflowMapper.selectPage(page,wrapper);
    }


}
