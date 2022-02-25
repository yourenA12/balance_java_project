package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 * 固定工资表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-25
 */
public interface FixedwageService extends IService<Fixedwage> {
    //分页查询固定工资表数据
    IPage<Fixedwage> selectFixedwagePage(IPage<Fixedwage> page, String staffNameSearch, ArrayList deptIds, String postSearch);



}
