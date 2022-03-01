package com.trkj.balance.modules.organization_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 职位表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-13
 */
public interface PositionService extends IService<Position> {

    //查询
    IPage<Position> selectPo(Page<Position>page);

    //部门查询
    List<Map<Object,Object>> selectDept();

}
