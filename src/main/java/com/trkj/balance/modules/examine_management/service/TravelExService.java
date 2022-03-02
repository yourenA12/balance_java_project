package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Travel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.Worker;

import java.util.List;

/**
 * <p>
 * 出差表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-24
 */
public interface TravelExService extends IService<Travel> {
    //添加方法
    int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails,Travel travel);

}
