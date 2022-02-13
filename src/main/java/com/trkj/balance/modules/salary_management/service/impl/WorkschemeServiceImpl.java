package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.trkj.balance.modules.salary_management.mapper.WorkschemeMapper;
import com.trkj.balance.modules.salary_management.service.WorkschemeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 加班方案表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-12
 */
@Service
public class WorkschemeServiceImpl extends ServiceImpl<WorkschemeMapper, Workscheme> implements WorkschemeService {

    @Autowired
    private WorkschemeMapper workschemeMapper;

    //添加加班方案
    @Override
    @Transactional
    public int insertWorkscheme(Workscheme workscheme) {
        return workschemeMapper.insert(workscheme);
    }

    //查询加班方案
    @Override
    public IPage<Workscheme> selectWorkscheme(Page<Workscheme> page) {
        return workschemeMapper.selectPage(page,null);
    }

    //修改加班方案状态
    @Override
    public int updateWorkschemeState(Workscheme workscheme) {
        return workschemeMapper.updateById(workscheme);
    }

    //删除加班方案
    @Override
    public int deleteWorkscheme(Long id) {
        return workschemeMapper.deleteById(id);
    }

    //根据id查询加班方案信息
    @Override
    public Workscheme selectWorkschemeId(Long id) {
        return workschemeMapper.selectById(id);
    }

    @Override
    public int updateWorkscheme(Workscheme workscheme) {
        return workschemeMapper.updateById(workscheme);
    }
}
