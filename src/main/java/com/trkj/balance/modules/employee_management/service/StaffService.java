package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.*;
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
    int insertStaff(Staff staff, WorkExperience workExperience, Education education, EmploymentTable employmentTable);

    //查询员工信息
    Staff selectStaffId(Long id);
}
