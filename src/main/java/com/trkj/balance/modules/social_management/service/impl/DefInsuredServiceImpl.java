package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.trkj.balance.modules.social_management.mapper.DefInsuredMapper;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 默认参保方案表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
@Service
public class DefInsuredServiceImpl extends ServiceImpl<DefInsuredMapper, DefInsured> implements DefInsuredService {

    @Autowired
    private DefInsuredMapper defInsuredMapper;

    // 查询所有参保方案
    @Override
    public IPage<DefInsured> selectAllPage(Page page, String name, Object state) {
        QueryWrapper queryWrapper= new QueryWrapper<>();
        if(name!=null && name!=""){
            queryWrapper.like("DEF_INSURED_NAME",name);
        }
        if( state!=null && state!=""){
            queryWrapper.eq("DEF_INSURED_STATE",state);
        }

        return defInsuredMapper.selectPage(page,queryWrapper);
    }

    // 删除参保方案
    @Override
    @Transactional
    public int deleteDefInsured(Long id) {
        return 0;
    }
}
