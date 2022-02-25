package com.trkj.balance.modules.recruitment_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.recruitment_management.entity.RecruitmentPlan;
import com.trkj.balance.modules.recruitment_management.mapper.RecruitmentPlanReMapper;
import com.trkj.balance.modules.recruitment_management.service.RecruitmentPlanReService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 招聘计划表 服务实现类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-22
 */
@Service
public class RecruitmentPlanReServiceImpl extends ServiceImpl<RecruitmentPlanReMapper, RecruitmentPlan> implements RecruitmentPlanReService {

    @Autowired
    private RecruitmentPlanReMapper recruitmentPlanMapper;

    @Override
    @Transactional
    public int insertzp(RecruitmentPlan RecruitmentPlan) {
        return recruitmentPlanMapper.insert(RecruitmentPlan);
    }

    @Override
    public int jihuasc(Long id) {
        return recruitmentPlanMapper.deleteById(id);
    }

    //修改招聘计划
    @Override
    public int updateRecruitmentPlan(RecruitmentPlan recruitmentPlan) {
        return recruitmentPlanMapper.updateById(recruitmentPlan);
    }
    //招聘计划名称
    @Override
    public List<Map<String, Object>> selectzpjh() {
        QueryWrapper<RecruitmentPlan> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("RECRUITMENT_PLAN_ID","RECRUITMENT_PLAN_NAME");
        queryWrapper.eq("IS_DELETED",0);
        return recruitmentPlanMapper.selectMaps(queryWrapper);
    }

    //根据id查询招聘计划信息
    @Override
    public RecruitmentPlan selectRecruitmentPlanId(Long id) {
        return recruitmentPlanMapper.selectById(id);
    }

}
