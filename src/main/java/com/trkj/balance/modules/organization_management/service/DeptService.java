package com.trkj.balance.modules.organization_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.organization_management.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

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


}
