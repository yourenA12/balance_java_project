package com.trkj.balance.modules.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.trkj.balance.modules.employee_management.mapper.GloryMapper;
import com.trkj.balance.modules.employee_management.mapper.PunishMapper;
import com.trkj.balance.modules.employee_management.service.GloryService;
import com.trkj.balance.modules.employee_management.service.PunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PunishServicelmpl extends ServiceImpl<PunishMapper, Punish> implements PunishService {

    @Autowired
    private PunishMapper punishMapper;

    @Override
    public List<Punish> selectPunishId(Long id) {
        // 声明一个条件构造器
        QueryWrapper wrapper = new QueryWrapper<>();
        // 按照员工id查询工作经历
        wrapper.eq("STAFF_ID",id);

        return punishMapper.selectList(wrapper);
    }

    @Override
    public int updatePunish(Punish punish) {
        return punishMapper.updateById(punish);
    }

    @Override
    public int insertPunish(Punish punish) {
        return punishMapper.insert(punish);
    }

    @Override
    public int deletePunishId(Long id) {
        return punishMapper.deleteById(id);
    }

    //分页查询惩罚表
    @Override
    public IPage<Punish> selectPunishPage(IPage<Punish> page, String staffName, ArrayList deptIds) {

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
        return punishMapper.selectPunishPage(page,wrapper);
    }
}
