package com.trkj.balance.modules.attendance_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.attendance_management.mapper.CardMapper;
import com.trkj.balance.modules.attendance_management.mapper.CardVoMapper;
import com.trkj.balance.modules.attendance_management.mapper.Dept_ClockRecordMapper;
import com.trkj.balance.modules.attendance_management.service.CardVoService;
import com.trkj.balance.modules.attendance_management.vo.CardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CardVoServiceImpl extends ServiceImpl<CardVoMapper, CardVo> implements CardVoService {
    @Autowired
    public CardVoMapper cardVoMapper;

    @Autowired
    public Dept_ClockRecordMapper dept_clockRecordMapper;

    @Override
    public IPage<CardVo> selectCart(int page, int size, String staffName, Object optionsDeptId, Date clockTimeStart, Date clockTimeEnd) {
        Page<CardVo> page1 = new Page<>(page,size);
        QueryWrapper<CardVo> wrapper = new QueryWrapper<>();
        //员工
        if( staffName!="" && staffName!=null) {
            wrapper.like("b.STAFF_NAME", staffName);
        }
        // 部门id
        if( optionsDeptId!="" && optionsDeptId!=null){
            wrapper.eq("c.DEPT_ID",optionsDeptId);
        }
        if( clockTimeStart != null ){
            // 记录时间
            wrapper.between("a.UPDATED_TIME",clockTimeStart,clockTimeEnd);
        }
        // 逻辑删除
        wrapper.eq("a.IS_DELETED",0);
        return cardVoMapper.selectCart(page1,wrapper);
    }

    @Override
    public List<Map<Object, Object>> dept() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.eq("IS_DELETED",0);
        return dept_clockRecordMapper.selectMaps(wrapper) ;
    }
}
