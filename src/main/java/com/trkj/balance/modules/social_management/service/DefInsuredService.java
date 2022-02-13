package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 默认参保方案表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
public interface DefInsuredService extends IService<DefInsured> {

    // 查询所有参保方案
    IPage<DefInsured> selectAllPage(Page page,String name,Object state);

    // 删除参保方案
    int deleteDefInsured(Long id);

    // 修改参保方案状态
    int updateDefInsuredState(DefInsured defInsured);

    // 新增参保方案
    int insertDefInsured(DefInsured defInsured);

}
