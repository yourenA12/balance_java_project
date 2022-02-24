package com.trkj.balance.modules.recruitment_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.recruitment_management.mapper.RecruitmentPlanVoMapper;
import com.trkj.balance.modules.recruitment_management.mapper.ResumeVoMapper;
import com.trkj.balance.modules.recruitment_management.service.RecruitmentPlanVoService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecruitmentPlanVoServiceImpl extends ServiceImpl<RecruitmentPlanVoMapper, RecruitmentPlanVo> implements RecruitmentPlanVoService {

    @Autowired
    private RecruitmentPlanVoMapper recruitmentPlanVoMapper;

    @Override
    public IPage<RecruitmentPlanVo> selectPage(int page, int size, String recruitmentPlanName) {
        Page<RecruitmentPlanVo> page1 = new Page<>(page,size);
        QueryWrapper<RecruitmentPlanVo> wrapper = new QueryWrapper<>();
        if (recruitmentPlanName!="" && recruitmentPlanName!=null){
            wrapper.like("rp.RECRUITMENT_PLAN_NAME",recruitmentPlanName);
        }
            wrapper.eq("rp.IS_DELETED",0);
        return recruitmentPlanVoMapper.queryPage(page1,wrapper);
    }
}
