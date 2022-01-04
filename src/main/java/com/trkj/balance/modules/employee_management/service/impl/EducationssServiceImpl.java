package com.trkj.balance.modules.employee_management.service.impl;

import com.trkj.balance.modules.employee_management.entity.Educationss;
import com.trkj.balance.modules.employee_management.mapper.EducationssMapper;
import com.trkj.balance.modules.employee_management.service.EducationssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 受教育经历表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2021-12-29
 */
@Service
public class EducationssServiceImpl extends ServiceImpl<EducationssMapper, Educationss> implements EducationssService {

    @Autowired
    private EducationssMapper educationssMapper;

    @Override
    public int insertEducation(Educationss educationss) {
        return educationssMapper.insert(educationss);
    }
}
