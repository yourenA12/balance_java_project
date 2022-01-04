package com.trkj.balance.modules.employee_management.service.impl;

import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.employee_management.mapper.EducationMapper;
import com.trkj.balance.modules.employee_management.mapper.EmploymentTableMapper;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.employee_management.mapper.WorkExperienceMapper;
import com.trkj.balance.modules.employee_management.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private EmploymentTableMapper employmentTableMapper;

    @Override
    @Transactional
    public int insertStaff(Staff staff, WorkExperience workExperience, Education education, EmploymentTable employmentTable) {
        // 添加员工表
        if (staffMapper.insert(staff) >0){

            // 将新加的员工表id 作为工作经历表的外键
            workExperience.setStaffId(staff.getStaffId());
            // 添加工作经历表
            if(workExperienceMapper.insert(workExperience) >0){

                // 将新加的员工表id 作为教育经历表的外键
                education.setStaffId(staff.getStaffId());
                // 添加教育经历表
                if(educationMapper.insert(education) >0){

                    // 修改简历表状态为，已入职
                    return employmentTableMapper.updateById(employmentTable);

                };
            };
        };

        return 0;
    }


}
