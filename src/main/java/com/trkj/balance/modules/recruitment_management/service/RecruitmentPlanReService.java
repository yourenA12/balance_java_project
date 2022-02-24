package com.trkj.balance.modules.recruitment_management.service;

import com.trkj.balance.modules.recruitment_management.entity.RecruitmentPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;

/**
 * <p>
 * 招聘计划表 服务类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-22
 */
public interface RecruitmentPlanReService extends IService<RecruitmentPlan> {


    // 添加招聘计划
    int insertzp(RecruitmentPlan recruitmentPlan);

    //删除招聘计划
    int jihuasc(Long id);

    //修改招聘计划
    int updateRecruitmentPlan(RecruitmentPlan recruitmentPlan);

    //根据id查询招聘计划信息
    RecruitmentPlan selectRecruitmentPlanId(Long id);
}
