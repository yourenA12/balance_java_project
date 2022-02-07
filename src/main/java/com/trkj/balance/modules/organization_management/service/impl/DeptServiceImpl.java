package com.trkj.balance.modules.organization_management.service.impl;

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
 * @since 2022-01-12
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    public DeptMapper deptMapper;

    //删除
    @Override
    public int deptdelete(Long id) {
        return deptMapper.deleteById(id);
    }

    //添加
    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    //修改
    @Override
    public int amend(Dept dept) {
        return deptMapper.updateById(dept);
    }
}
