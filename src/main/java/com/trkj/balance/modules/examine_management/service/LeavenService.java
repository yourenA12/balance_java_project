package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Leave;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.Worker;

import java.util.List;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-19
 */
public interface LeavenService extends IService<Leave> {
    //添加方法
    int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Leave leave);
}
