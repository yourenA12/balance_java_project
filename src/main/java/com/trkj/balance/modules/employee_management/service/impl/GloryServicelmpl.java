package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.entity.Quit;
import com.trkj.balance.modules.employee_management.mapper.GloryMapper;
import com.trkj.balance.modules.employee_management.mapper.Quit_StaffMapper;
import com.trkj.balance.modules.employee_management.service.GloryService;
import com.trkj.balance.modules.employee_management.service.Quit_StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GloryServicelmpl extends ServiceImpl<GloryMapper, Glory> implements GloryService {

    @Autowired
    private GloryMapper gloryMapper;

    @Override
    public List<Glory> selectGloryId(Long id) {
        // 声明一个条件构造器
        QueryWrapper wrapper = new QueryWrapper<>();
        // 按照员工id查询工作经历
        wrapper.eq("STAFF_ID",id);

        return gloryMapper.selectList(wrapper);
    }

    @Override
    public int updateGlory(Glory glory) {
        return gloryMapper.updateById(glory);
    }

    @Override
    public int deleteGlory(Long id) {
        return gloryMapper.deleteById(id);
    }

    @Override
    public int insertGlory(Glory glory) {
        return gloryMapper.insert(glory);
    }


}
