package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Overtimeask;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 * <p>
 * 加班表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
public interface OvertimeaskNService extends IService<Overtimeask> {
    //添加方法
    int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Overtimeask overtimeask);
}
