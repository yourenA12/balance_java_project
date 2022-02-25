package com.trkj.balance.modules.salary_management.service;

import com.trkj.balance.modules.salary_management.entity.CompensationStaff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 * 薪酬组员工中间表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-23
 */
public interface CompensationStaffService extends IService<CompensationStaff> {
    //根据薪酬组员工中间表查询数据
    String selectCompensationStaffName(ArrayList<Integer> staffIds);

}
