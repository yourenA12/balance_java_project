package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.attendance_management.mapper.Dept_ClockRecordMapper;
import com.trkj.balance.modules.attendance_management.mapper.TravelVoMapper;
import com.trkj.balance.modules.attendance_management.service.TravelVoService;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TravelVoServiceImpl extends ServiceImpl<TravelVoMapper, TravelVo> implements TravelVoService {

    @Autowired
    public TravelVoMapper travelVoMapper;

    @Autowired
    public Dept_ClockRecordMapper dept_clockRecordMapper;

    //分页查询
    @Override
    public IPage<TravelVo> selectTravel(int page, int size, String staffName, Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd) {
        Page<TravelVo> page1 = new Page<>(page,size);
        QueryWrapper<TravelVo> wrapper = new QueryWrapper<>();
        //员工名称
        if( staffName!="" && staffName!=null) {
            wrapper.like("c.STAFF_NAME", staffName);
        }
        // 部门id
        if( optionsDeptId!="" && optionsDeptId!=null){
            wrapper.eq("a.DEPT_ID",optionsDeptId);
        }
        if( clockTimeStart != null ){
            // 记录时间
            wrapper.between("a.UPDATED_TIME",clockTimeStart,clockTimeEnd);
        }
        // 逻辑删除
        wrapper.eq("a.IS_DELETED",0);
        return travelVoMapper.selectTravel(page1,wrapper);
    }

    @Override
    public List<Map<Object, Object>> dept() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.eq("IS_DELETED",0);
        return dept_clockRecordMapper.selectMaps(wrapper);
    }
}
