package com.trkj.balance.modules.recruitment_management.service;

import com.trkj.balance.modules.recruitment_management.entity.EmploymentTable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.entity.Resume;

/**
 * <p>
 * 录用表 服务类
 * </p>
 *
 * @author 米西米西
 * @since 2022-03-01
 */
public interface EmploymentTableService extends IService<EmploymentTable> {

    //录用
    int insertEmploymentTable(EmploymentTable employmentTable, Resume resume);

}
