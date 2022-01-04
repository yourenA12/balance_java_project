package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.attendance_management.mapper.ClassesMapper;
import com.trkj.balance.modules.attendance_management.service.ClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班次方案表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2021-12-30
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {
    @Autowired
    public ClassesMapper classesMapper;

    //分页查询
    @Override
    public IPage<Classes> selsefy(Page<Classes> page) {
        return classesMapper.selectPage(page,null);
    }

    //新增
    @Override
    public int selsetj(Classes classes) {
        return classesMapper.insert(classes);
    }

    @Override
    public int selsesc(Long id) {
        return classesMapper.deleteById(id);
    }

    //逻辑删除





}
