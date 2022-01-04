package com.trkj.balance.modules.employee_management.service.impl;

import com.trkj.balance.modules.employee_management.entity.WorkExperiencess;
import com.trkj.balance.modules.employee_management.mapper.WorkExperiencessMapper;
import com.trkj.balance.modules.employee_management.service.WorkExperiencessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作经历表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2021-12-29
 */
@Service
public class WorkExperiencessServiceImpl extends ServiceImpl<WorkExperiencessMapper, WorkExperiencess> implements WorkExperiencessService {
   @Autowired
   private  WorkExperiencessMapper workExperiencessMapper;

    @Override
    public int insertWorkExperience(WorkExperiencess workExperiencess) {
        return workExperiencessMapper.insert(workExperiencess);
    }
}
