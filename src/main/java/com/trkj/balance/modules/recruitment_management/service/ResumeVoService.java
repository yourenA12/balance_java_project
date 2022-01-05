package com.trkj.balance.modules.recruitment_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;

public interface ResumeVoService extends IService<ResumeVo> {

    IPage<ResumeVo> ResumePage(Page<ResumeVo> page);

    IPage<ResumeVo> ResumePage_a(Page<ResumeVo> page);

    IPage<ResumeVo> ResumePage_D(Page<ResumeVo> page);

    IPage<ResumeVo> ResumePage_H(Page<ResumeVo> page);

    IPage<ResumeVo> ResumePage_Y(Page<ResumeVo> page);
}
