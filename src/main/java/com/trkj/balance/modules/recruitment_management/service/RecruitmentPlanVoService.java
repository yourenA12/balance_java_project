package com.trkj.balance.modules.recruitment_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;

public interface RecruitmentPlanVoService extends IService<RecruitmentPlanVo> {

    IPage<RecruitmentPlanVo> selectPage(Page<RecruitmentPlanVo> page);


}
