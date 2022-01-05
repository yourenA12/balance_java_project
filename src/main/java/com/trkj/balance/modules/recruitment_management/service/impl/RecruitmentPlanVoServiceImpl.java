package com.trkj.balance.modules.recruitment_management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.recruitment_management.mapper.RecruitmentPlanVoMapper;
import com.trkj.balance.modules.recruitment_management.service.RecruitmentPlanVoService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecruitmentPlanVoServiceImpl extends ServiceImpl<RecruitmentPlanVoMapper, RecruitmentPlanVo> implements RecruitmentPlanVoService {

    @Autowired
    private RecruitmentPlanVoMapper recruitmentPlanVoMapper;

    @Override
    public IPage<RecruitmentPlanVo> selectPage(Page<RecruitmentPlanVo> page) {
        return recruitmentPlanVoMapper.queryPage(page);

    }
}
