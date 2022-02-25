package com.trkj.balance.modules.social_management.service;

import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 * 参保方案员工中间表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
public interface InsuredStaffService extends IService<InsuredStaff> {

    //根据员工id查询，参保方案员工中间表有无数据
    String selectInsuredStaffName(ArrayList<Integer> staffIds);

}
