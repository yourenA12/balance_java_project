package com.trkj.balance.modules.recruitment_management.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.recruitment_management.mapper.ResumeVoMapper;
import com.trkj.balance.modules.recruitment_management.service.ResumeVoService;
import com.trkj.balance.modules.recruitment_management.vo.ResumeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeVoServiceImpl extends ServiceImpl<ResumeVoMapper, ResumeVo> implements ResumeVoService {

    @Autowired
    private  ResumeVoMapper  resumeVoMapper;

    @Override
    public IPage<ResumeVo> ResumePage(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage(page);
    }

    @Override
    public IPage<ResumeVo> ResumePage_a(Page<ResumeVo> page) { return resumeVoMapper.ResumePage_a(page);}


    @Override
    public IPage<ResumeVo> ResumePage_D(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage_D(page);
    }

    @Override
    public IPage<ResumeVo> ResumePage_H(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage_H(page);
    }

    @Override
    public IPage<ResumeVo> ResumePage_Y(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage_Y(page);
    }


}
