package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.attendance_management.mapper.ClockVoMapper;
import com.trkj.balance.modules.attendance_management.mapper.Dept_ClockRecordMapper;
import com.trkj.balance.modules.attendance_management.service.ClockVoService;
import com.trkj.balance.modules.attendance_management.vo.ClockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ClockVoServiceImpl extends ServiceImpl<ClockVoMapper, ClockVo> implements ClockVoService {

    @Autowired
    public ClockVoMapper clockVoMapper;

    //部门状态查询
    @Autowired
    public Dept_ClockRecordMapper deptMapper_clockRecord;


    //模糊分页查询 + 搜索
    @Override
    public IPage<ClockVo> dimsearch(int page, int size, String staffName, Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd){
        Page<ClockVo> pagss=new Page<>(page,size);
        QueryWrapper<ClockVo> wrapper = new QueryWrapper<>();
        // 员工姓名
        if( staffName!="" && staffName!=null) {
            wrapper.like("a.STAFF_NAME", staffName);
        }
        // 部门id
        if( optionsDeptId!="" && optionsDeptId!=null ){
            wrapper.eq("c.DEPT_ID",optionsDeptId);
        }
        if( clockTimeStart != null ){
            // 记录时间
            wrapper.between("a.UPDATED_TIME",clockTimeStart,clockTimeEnd);
        }

        // 逻辑删除
        wrapper.eq("a.IS_DELETED",0);
        IPage<ClockVo> namedk=clockVoMapper.selectClok1(pagss,wrapper);
        return namedk;
    }

    // 部门查询
    @Override
    public List<Map<Object, Object>> selectAllDept() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.eq("IS_DELETED",0);
        return deptMapper_clockRecord.selectMaps(wrapper);
    }


}
