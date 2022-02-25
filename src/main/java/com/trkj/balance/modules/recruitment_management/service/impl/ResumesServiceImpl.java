package com.trkj.balance.modules.recruitment_management.service.impl;

import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.mapper.ResumesMapper;
import com.trkj.balance.modules.recruitment_management.service.ResumesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 简历表 服务实现类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-24
 */
@Service
public class ResumesServiceImpl extends ServiceImpl<ResumesMapper, Resume> implements ResumesService {

    @Autowired
    public ResumesMapper resumeMapper;

    @Transactional
    @Override
    public int updateeliminate(Resume resume) {
        return resumeMapper.updateById(resume);
    }


    @Override
    public int updatexinjl(Resume resume) {
        return resumeMapper.updateById(resume);
    }
}
