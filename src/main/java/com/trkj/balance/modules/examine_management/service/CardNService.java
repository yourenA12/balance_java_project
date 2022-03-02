package com.trkj.balance.modules.examine_management.service;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.trkj.balance.modules.examine_management.entity.Auditflowdetail;
import com.trkj.balance.modules.examine_management.entity.Card;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.Leave;

import java.util.List;

/**
 * <p>
 * 补打卡表 服务类
 * </p>
 *
 * @author jiejie
 * @since 2022-02-28
 */
public interface CardNService extends IService<Card> {
    //补打卡添加方法
    int insertStaff(Auditflow auditflow, List<Auditflowdetail> auditflowdetails, Card card);
}


