package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.trkj.balance.modules.attendance_management.mapper.ClassesMapper;
import com.trkj.balance.modules.attendance_management.service.ClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //逻辑删除
    @Override
    public int selsesc(Long id) {
        return classesMapper.deleteById(id);
    }

    //修改
    @Override
    @Transactional //事务注解
    public int amend(Classes classes) {
        // 首先执行修改所有状态为禁用
//         classesMapper.updateAllState();

        Classes a = new Classes();
        a.setClassesState(1L);

        classesMapper.update(a,null);

        // 成功后，启用指定的 班次
        return classesMapper.updateById(classes);
    }

    //模糊搜索
    @Override
    public IPage<Classes> dimsearch(int page, int size, String classesName) {
        Page<Classes> pagess=new Page<>(page,size);
        QueryWrapper<Classes> wrapper = new QueryWrapper<>();
        wrapper.like("CLASSES_NAME",classesName);
        IPage<Classes> namepage=classesMapper.selectPage(pagess,wrapper);
        return namepage;
    }


}
