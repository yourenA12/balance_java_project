package com.trkj.balance.modules.recruitment_management.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public IPage<ResumeVo> ResumePage_Z(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage_Z(page);
    }

    @Override
    public IPage<ResumeVo> ResumePage_F(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage_F(page);
    }

    @Override
    public IPage<ResumeVo> ResumePage_T(Page<ResumeVo> page) {
        return resumeVoMapper.ResumePage_T(page);
    }

    @Override
    public ResumeVo SelectRexumeId(Long id) {
        return resumeVoMapper.SelectRexumeId(id);
    }

    @Override
    public IPage<ResumeVo> ResumePage_K(int page, int size, String resumeName) {
        Page<ResumeVo> page1=new Page<>(page,size);
        QueryWrapper<ResumeVo> wrapper=new QueryWrapper<>();
        wrapper.like("RESUME_NAME",resumeName);
        IPage<ResumeVo> page2=resumeVoMapper.selectPage(page1,wrapper);
        return page2;
    }


}
