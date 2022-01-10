package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;

/**
 * <p>
 * 工作经历表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2021-12-31
 */
public interface WorkExperienceService extends IService<WorkExperience> {

    IPage<WorkExperience> selectWorkExperience(Page<WorkExperience> page);
}
