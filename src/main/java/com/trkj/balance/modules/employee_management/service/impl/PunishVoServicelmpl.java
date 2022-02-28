package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.trkj.balance.modules.employee_management.mapper.PunishMapper;
import com.trkj.balance.modules.employee_management.mapper.PunishVoMapper;
import com.trkj.balance.modules.employee_management.service.PunishService;
import com.trkj.balance.modules.employee_management.service.PunishVoService;
import com.trkj.balance.modules.employee_management.vo.PunishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PunishVoServicelmpl extends ServiceImpl<PunishVoMapper, PunishVo> implements PunishVoService {

    @Autowired
    private PunishVoMapper punishVoMapper;

    //分页查询惩罚表
    @Override
    public IPage<PunishVo> selectPunishPage(IPage<PunishVo> page, String staffName, ArrayList deptIds) {

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
        return punishVoMapper.selectPunishPage(page,wrapper);
    }


}
