package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.entity.Dept;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import com.trkj.balance.modules.organization_management.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-10
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    public DeptMapper deptMapper;

    //分页查询
    @Override
    public IPage<Dept> deptfy(Page<Dept> page) {
        return deptMapper.selectPage(page,null);
    }
}
