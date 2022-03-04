package com.trkj.balance.modules.social_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.social_management.entity.InsuredDetailSon;
import com.trkj.balance.modules.social_management.mapper.InsuredDetailSonMapper;
import com.trkj.balance.modules.social_management.service.InsuredDetailSonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-03-01
 */
@Service
public class InsuredDetailSonServiceImpl extends ServiceImpl<InsuredDetailSonMapper, InsuredDetailSon> implements InsuredDetailSonService {

    @Autowired
    private InsuredDetailSonMapper insuredDetailSonMapper;

    // 按员工id和月份查询参保明细详情
    @Override
    public List<InsuredDetailSon> selectInsuredDetailSon(Long id,String date) {
        return insuredDetailSonMapper.selectByIdByDate(id,date);
    }
}
