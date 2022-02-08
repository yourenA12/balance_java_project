package com.trkj.balance.modules.salary_management.service;

import com.trkj.balance.modules.salary_management.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
public interface DeptSalaryService extends IService<Dept> {
    //查询所有部门
    List<Dept> queryList();


}
