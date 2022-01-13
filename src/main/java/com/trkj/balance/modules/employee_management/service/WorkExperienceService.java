package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;

import java.util.List;

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

    //花名册 编辑里根据id查询工作经历
    List<WorkExperience> selectWorkExperienceId(Long id);

    //修改工作经历
    int updateWorkExperienceId(WorkExperience workExperience);

    //删除工作经历
    int deleteWorkExperienceId(Long id);

    //添加工作经历
    int insertWorkExperience(WorkExperience workExperience);

}
