package com.trkj.balance.modules.recruitment_management.service;

import com.trkj.balance.modules.recruitment_management.entity.Educationss;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.entity.Resume;

/**
 * <p>
 * 受教育经历表 服务类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-28
 */
public interface EducationssService extends IService<Educationss> {
    //修改教育经历
    int updateEdcationss(Educationss educationss);
    //根据id查教育经历
    Educationss selectEdcationss(Long id);
}
