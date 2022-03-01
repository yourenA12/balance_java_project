package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.mapper.GloryMapper;
import com.trkj.balance.modules.employee_management.mapper.GloryVoMapper;
import com.trkj.balance.modules.employee_management.service.GloryService;
import com.trkj.balance.modules.employee_management.service.GloryVoService;
import com.trkj.balance.modules.employee_management.vo.GloryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GloryVoServicelmpl extends ServiceImpl<GloryVoMapper, GloryVo> implements GloryVoService {

    @Autowired
    private GloryVoMapper gloryVoMapper;

    //分页查询奖励表
    @Override
    public IPage<GloryVo> selectGloryPage(IPage<GloryVo> page, String staffName, ArrayList deptIds) {

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


        return gloryVoMapper.selectGloryPage(page,wrapper);
    }


}
