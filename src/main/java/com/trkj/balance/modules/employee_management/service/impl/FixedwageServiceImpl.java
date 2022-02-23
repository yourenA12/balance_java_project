package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Fixedwage;
import com.trkj.balance.modules.employee_management.mapper.FixedwageMapper;
import com.trkj.balance.modules.employee_management.service.FixedwageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 固定工资表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-25
 */
@Service
public class FixedwageServiceImpl extends ServiceImpl<FixedwageMapper, Fixedwage> implements FixedwageService {

    @Autowired
    private FixedwageMapper fixedwageMapper;

    //分页查询固定工资表数据
    @Override
    public IPage<Fixedwage> selectFixedwagePage(IPage<Fixedwage> page) {
        return fixedwageMapper.selectFixedwagePage(page);
    }


}
