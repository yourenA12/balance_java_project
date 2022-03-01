package com.trkj.balance.modules.recruitment_management.service.impl;

import com.trkj.balance.modules.recruitment_management.entity.Educationss;
import com.trkj.balance.modules.recruitment_management.entity.RecruitmentPlan;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;
import com.trkj.balance.modules.recruitment_management.mapper.EducationssMapper;
import com.trkj.balance.modules.recruitment_management.mapper.ResumesMapper;
import com.trkj.balance.modules.recruitment_management.mapper.WorkExperiencessMapper;
import com.trkj.balance.modules.recruitment_management.service.ResumesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-24
 */
@Service
public class ResumesServiceImpl extends ServiceImpl<ResumesMapper, Resume> implements ResumesService {

    @Autowired
    private ResumesMapper resumeMapper;

    @Autowired
    private EducationssMapper educationssMapper;

    @Autowired
    private WorkExperiencessMapper workExperiencessMapper;



    @Transactional
    @Override
    public int updateeliminate(Resume resume) {
        return resumeMapper.updateById(resume);
    }


    @Override
    public int updatexinjl(Resume resume) {
        return resumeMapper.updateById(resume);
    }

    //  修改简历
    @Override
    @Transactional
    public int updateResume(Resume resume,Educationss educationss, WorkExperiencess workExperiencess) {

        resumeMapper.updateById(resume);
        educationssMapper.updateById(educationss);
        workExperiencessMapper.updateById(workExperiencess);

        return 1;
    }
    //添加简历
    @Override
    @Transactional
    public int insertResume(Resume resume, Educationss educationss, WorkExperiencess workExperiencess) {
        if (resumeMapper.insert(resume)>0){
            educationss.setResumeId(resume.getResumeId());

            if (educationssMapper.insert(educationss)>0){
                workExperiencess.setResumeId(resume.getResumeId());

                if (workExperiencessMapper.insert(workExperiencess)>0){
                    return 1;
                }
            }
        }

        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }
    //根据id查简历
    @Override
    public Resume selectResumes(Long id) {
        return resumeMapper.selectById(id);
    }
}
