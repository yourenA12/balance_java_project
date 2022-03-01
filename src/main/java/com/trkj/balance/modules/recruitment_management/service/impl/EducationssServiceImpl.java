package com.trkj.balance.modules.recruitment_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.recruitment_management.entity.Educationss;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.mapper.EducationssMapper;
import com.trkj.balance.modules.recruitment_management.service.EducationssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 受教育经历表 服务实现类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-28
 */
@Service
public class EducationssServiceImpl extends ServiceImpl<EducationssMapper, Educationss> implements EducationssService {

    @Autowired
    private EducationssMapper educationssMapper;


    //修改教育经历
    @Override
    public int updateEdcationss(Educationss educationss) {
        return educationssMapper.updateById(educationss);
    }
    //根据id查教育经历
    @Override
    public Educationss selectEdcationss(Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("RESUME_ID",id);
        return educationssMapper.selectOne(wrapper);
    }
}
