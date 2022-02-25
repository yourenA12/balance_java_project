package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.vo.GloryPunishVo;

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
    int insertStaff(Staff staff, WorkExperience workExperience, Education education, Resume resume,Fixedwage fixedwage);

    //修改简历表状态和录用表放弃原应
    int updateResumen(Resume resume,EmploymentTable employment_table);

    //查询员工信息
    Staff selectStaffId(Long id);

    //修改员工
    int updateStaff(Staff staff);

    //查询员工的状态，统计人数
    int selectStaffStateCount(int state);

    //查询本月离职和本月新入职员工
    int selectStaffDate(String date);

    //统计离职、在职、试用的员工人数
    int selectCountStaff(String staffState);

}
