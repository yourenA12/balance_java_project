package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.Educationss;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 受教育经历表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2021-12-29
 */
public interface EducationssService extends IService<Educationss> {

    //添加受教育经历表  员工
    int insertEducation(Educationss educationss);
}
