package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.employee_management.mapper.EducationMapper;
import com.trkj.balance.modules.employee_management.service.EducationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 受教育经历表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-19
 */
@Service
public class EducationServiceImpl extends ServiceImpl<EducationMapper, Education> implements EducationService {


    @Autowired
    private EducationMapper educationMapper;

    @Override
    public List<Education> selectEducationId(Long id) {
        // 声明一个条件构造器
        QueryWrapper wrapper = new QueryWrapper<>();
        // 按照员工id查询工作经历
        wrapper.eq("STAFF_ID",id);
        return educationMapper.selectList(wrapper);
    }

    @Override
    public int updateEducation(Education education) {
        return educationMapper.updateById(education);
    }

    @Override
    public int deleteEducationId(Long id) {
        return educationMapper.deleteById(id);
    }

    @Override
    public int insertEducation(Education education) {
        return educationMapper.insert(education);
    }
}
