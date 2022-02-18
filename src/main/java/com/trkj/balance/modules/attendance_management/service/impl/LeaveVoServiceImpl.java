package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.attendance_management.mapper.Dept_ClockRecordMapper;
import com.trkj.balance.modules.attendance_management.mapper.LeaveVoMapper;
import com.trkj.balance.modules.attendance_management.service.LeaveVoService;
import com.trkj.balance.modules.attendance_management.vo.LeaveVo;
import com.trkj.balance.modules.attendance_management.vo.OvertVo;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LeaveVoServiceImpl extends ServiceImpl<LeaveVoMapper, LeaveVo> implements LeaveVoService {
    @Autowired
    public LeaveVoMapper leaveVoMapper;

    @Autowired
    public Dept_ClockRecordMapper dept_clockRecordMapper;

    @Override
    public IPage<LeaveVo> selsectLeave(int page, int size , String staffName , Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd) {
        Page<LeaveVo> pagss = new Page<>(page,size);
        QueryWrapper<LeaveVo> wrapper = new QueryWrapper<>();

        //员工名称
        if( staffName!="" && staffName!=null) {
            wrapper.like("c.STAFF_NAME", staffName);
        }
        //部门
        if( optionsDeptId!="" && optionsDeptId!=null ){
            wrapper.eq("a.DEPT_ID",optionsDeptId);
        }
        if( clockTimeStart != null ){
            // 记录时间
            wrapper.between("a.UPDATED_TIME",clockTimeStart,clockTimeEnd);
        }
        // 逻辑删除
        wrapper.eq("a.IS_DELETED",0);
        return leaveVoMapper.selsectLeave(pagss,wrapper);
    }

    @Override
    public List<Map<Object, Object>> selectDept() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.eq("IS_DELETED",0);
        return dept_clockRecordMapper.selectMaps(wrapper);
    }
}
