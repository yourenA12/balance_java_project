package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
public interface StaffService extends IService<Staff> {

    //添加员工表
    int insertStaff(Staff staff);

}
