package com.trkj.balance.modules.salary_management.service;

import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;

/**
 * <p>
 * 薪酬组表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
public interface CompensationService extends IService<Compensation> {

    //添加薪酬组
    int insertCompensation(Compensation compensation, CompensationDeptPost compensationDeptPost);

}
