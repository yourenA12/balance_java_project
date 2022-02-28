package com.trkj.balance.modules.recruitment_management.service;

import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.recruitment_management.entity.Educationss;
import com.trkj.balance.modules.recruitment_management.entity.RecruitmentPlan;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;

/**
 * <p>
 * 简历表 服务类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-24
 */
public interface ResumesService extends IService<Resume> {
    //修改状态
    int updateeliminate(Resume resume);
    //新简历转入淘汰库
    int updatexinjl(Resume resume);
    //修改简历
    int updateResume(Resume resume, Educationss educationss, WorkExperiencess workExperiencess);
    //添加简历
    int insertResume(Resume resume, Educationss educationss, WorkExperiencess workExperiencess);
    //根据id简历信息
    Resume selectResumes(Long id);

}
