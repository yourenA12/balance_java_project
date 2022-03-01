package com.trkj.balance.modules.recruitment_management.service;

import com.trkj.balance.modules.recruitment_management.entity.WorkExperiencess;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工作经历表 服务类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-28
 */
public interface WorkExperiencessService extends IService<WorkExperiencess> {

    //修改工作经历
    int updateWork(WorkExperiencess workExperiencess);
    //根据id查工作经历
    WorkExperiencess selectWork(Long id);

}
