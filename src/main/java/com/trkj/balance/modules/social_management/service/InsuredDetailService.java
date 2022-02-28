package com.trkj.balance.modules.social_management.service;

import com.trkj.balance.modules.social_management.entity.InsuredDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 参保明细表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-02-28
 */
public interface InsuredDetailService extends IService<InsuredDetail> {

    // 按id删除参保明细
    int deleteInsuredDetail(List<Integer> ids);

}
