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

    //分页查询奖励表
    @Override
    public IPage<Glory> selectGloryPage(IPage<Glory> page, String staffName, ArrayList deptIds) {

        // 声明一个条件构造器
        QueryWrapper wrapper = new QueryWrapper<>();
        if(staffName!=null && staffName!="" ){
            // 按照员工id查询工作经历
            wrapper.like("s.STAFF_NAME",staffName);
        }
        if(deptIds.size()!=0 && deptIds!=null){
            // 按照部门id查询
            wrapper.in("d.DEPT_ID",deptIds);
        }


        return gloryMapper.selectGloryPage(page,wrapper);
    }
}
