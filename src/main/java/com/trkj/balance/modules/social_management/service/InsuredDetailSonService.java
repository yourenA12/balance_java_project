package com.trkj.balance.modules.social_management.service;

import com.trkj.balance.modules.social_management.entity.InsuredDetailSon;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-03-01
 */
public interface InsuredDetailSonService extends IService<InsuredDetailSon> {

    //根据员工id查询参保明细详情信息
    List<InsuredDetailSon> selectInsuredDetailSon(Long id);

}
