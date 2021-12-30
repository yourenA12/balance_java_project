package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.WorkExperiencess;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工作经历表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2021-12-29
 */
public interface WorkExperiencessService extends IService<WorkExperiencess> {

    //添加工作经历表  员工
    int insertWorkExperience(WorkExperiencess workExperiencess);
}
