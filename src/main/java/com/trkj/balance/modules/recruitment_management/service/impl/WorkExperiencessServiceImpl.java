package com.trkj.balance.modules.recruitment_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;
import com.trkj.balance.modules.recruitment_management.mapper.WorkExperiencessMapper;
import com.trkj.balance.modules.recruitment_management.service.WorkExperiencessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-28
 */
@Service
public class WorkExperiencessServiceImpl extends ServiceImpl<WorkExperiencessMapper, WorkExperiencess> implements WorkExperiencessService {
    @Autowired
    private WorkExperiencessMapper workExperiencessMapper;

    //修改工作经历
    @Override
    public int updateWork(WorkExperiencess workExperiencess) {
        return workExperiencessMapper.updateById(workExperiencess);
    }


    //根据id查工作经历
    @Override
    public WorkExperiencess selectWork(Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("RESUME_ID",id);
        return workExperiencessMapper.selectOne(wrapper);
    }
}
