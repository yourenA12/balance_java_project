package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.social_management.entity.InsuredDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
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

    // 按员工id删除参保
    int deleteInsuredAll(ArrayList<Integer> staffIds);

    //根据id查询参保明细
    IPage<InsuredDetail> selectInsuredDetailPage(IPage<InsuredDetail> page,Long id);

}
