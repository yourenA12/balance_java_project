package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.employee_management.mapper.WorkExperienceMapper;
import com.trkj.balance.modules.employee_management.service.WorkExperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2021-12-31
 */
@Service
public class WorkExperienceServiceImpl extends ServiceImpl<WorkExperienceMapper, WorkExperience> implements WorkExperienceService {
    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Override
    public IPage<WorkExperience> selectWorkExperience(Page<WorkExperience> page) {
        return workExperienceMapper.selectWorkExperience(page);
    }

}
