package com.trkj.balance.modules.organization_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.organization_management.entity.Dept;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-12
 */
public interface DeptService extends IService<Dept> {
    //删除
    public int deptdelete (Long id);

    // 新增
    int insert(Dept dept);

    //修改
    int amend(Dept dept);

    //上下级查询
    List<Dept> queryList();




}
