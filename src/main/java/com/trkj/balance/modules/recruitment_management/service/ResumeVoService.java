package com.trkj.balance.modules.recruitment_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;

public interface ResumeVoService extends IService<ResumeVo> {
    //全部简历
    IPage<ResumeVo> ResumePage(int page,int size,String resumeName);
    //新简历
    IPage<ResumeVo> ResumePage_a(Page<ResumeVo> page);
    //候选人
    IPage<ResumeVo> ResumePage_D(Page<ResumeVo> page);
    //淘汰
    IPage<ResumeVo> ResumePage_H(Page<ResumeVo> page);
    //已邀约
    IPage<ResumeVo> ResumePage_Y(Page<ResumeVo> page);
    //面试中
    IPage<ResumeVo> ResumePage_Z(Page<ResumeVo> page);
    //复试中
    IPage<ResumeVo> ResumePage_F(Page<ResumeVo> page);
    //面试通过
    IPage<ResumeVo> ResumePage_T(Page<ResumeVo> page);
    //根据id简历详情
    ResumeVo SelectRexumeId(Long id);
}
