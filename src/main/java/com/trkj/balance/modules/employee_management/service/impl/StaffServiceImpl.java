package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.employee_management.entity.*;
import com.trkj.balance.modules.employee_management.mapper.*;
import com.trkj.balance.modules.employee_management.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    //员工表
    @Autowired
    private StaffMapper staffMapper;

    //工作经历表 员工
    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    //教育经历  员工
    @Autowired
    private EducationMapper educationMapper;

    //简历表
    @Autowired
    private ResumeMapper resumeMapper;

    //录用表
    @Autowired
    private EmploymentTableMapper employmentTableMapper;

    //固定工资表
    @Autowired
    private FixedwageMapper fixedwageMapper;




    @Override
    @Transactional
    public int insertStaff(Staff staff, WorkExperience workExperience, Education education, Resume resume,Fixedwage fixedwage) {

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //
        Calendar c = Calendar.getInstance();
        // 员工入职日期
        c.setTime( staff.getStaffHiredate() );
        // 加三个月
        c.add(Calendar.MONTH, 3);

        // 将入职日期后三个月 写入 转正日期中
        staff.setWorkerDate( c.getTime() );

        // 添加员工表
        if (staffMapper.insert(staff) > 0) {

            // 将新加的员工表id 作为工作经历表的外键
            workExperience.setStaffId(staff.getStaffId());
            // 添加工作经历表
            if (workExperienceMapper.insert(workExperience) > 0) {

                // 将新加的员工表id 作为教育经历表的外键
                education.setStaffId(staff.getStaffId());
                // 添加教育经历表
                if (educationMapper.insert(education) > 0) {
                    //将新加的员工表id 作为固定工资表的外键
                    fixedwage.setStaffId(staff.getStaffId());
                    //添加固定工资表
                    if(fixedwageMapper.insert(fixedwage)>0){
                        // 修改简历表状态为，已入职
                        return resumeMapper.updateById(resume);

                    }

                }
                ;
            }
            ;
        }
        ;

        return 0;
    }

    //修改简历状态和录用原因
    @Override
    @Transactional
    public int updateResumen(Resume resume, EmploymentTable employment_table) {
        if (employmentTableMapper.updateById(employment_table) > 0) {
            return resumeMapper.updateById(resume);
        }
        return 0;
    }

    @Override
    public Staff selectStaffId(Long id) {
        return staffMapper.selectById(id);
    }

    //修改员工
    @Override
    public int updateStaff(Staff staff) {
        return staffMapper.updateById(staff);
    }

    //查询员工的状态，统计人数
    @Override
    public int selectStaffStateCount(int state) {
        // 声明一个条件构造器
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();



        return 0;
    }

    //查询本月离职和本月新入职员工
    @Override
    public int selectStaffDate(String date) {
        return 0;
    }


}
