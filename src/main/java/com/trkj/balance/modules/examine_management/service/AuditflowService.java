package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.employee_management.entity.Resume;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Worker;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;

import java.util.List;

/**
 * <p>
 * 审批主表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
public interface AuditflowService extends IService<Auditflow> {
    //添加方法
    int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Worker worker);
    //修改主表状态
    int updateAuditflow(Auditflow auditflow);
    //根据id 查询
    IPage<Auditflow> findSelectId(Page<Auditflow> page,int id);
}
