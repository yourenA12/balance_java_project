package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.entity.Position;
import com.trkj.balance.modules.organization_management.mapper.PositionMapper;
import com.trkj.balance.modules.organization_management.service.PositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 职位表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-13
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    @Autowired
    public PositionMapper positionMapper;

    @Override
    public IPage<Position> selectPo(Page<Position> page) {
        return positionMapper.selectPage(page,null);
    }
}
