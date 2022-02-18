package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.Education;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 受教育经历表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-19
 */
public interface EducationService extends IService<Education> {

    //查询教育经历表信息
    List<Education> selectEducationId(Long id);

    //修改教育经历表信息
    int updateEducation(Education education);

    //删除教育经历表信息
    int deleteEducationId(Long id);

    //添加教育经历表信息
    int insertEducation(Education education);


}
