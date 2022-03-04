package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Quit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 离职表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-21
 */
public interface QuitnService extends IService<Quit> {
    //添加方法
    int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Quit quit);


}
