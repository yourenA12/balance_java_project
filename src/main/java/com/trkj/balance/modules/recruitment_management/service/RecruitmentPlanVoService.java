package com.trkj.balance.modules.recruitment_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.vo.RecruitmentPlanVo;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;

public interface RecruitmentPlanVoService extends IService<RecruitmentPlanVo> {



    IPage<RecruitmentPlanVo> selectPage(int page, int size, String recruitmentPlanName);


}
