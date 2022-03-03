package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.attendance_management.mapper.OvertimeaskMapper;
import com.trkj.balance.modules.examine_management.mapper.OvertimeaskVoMapper;
import com.trkj.balance.modules.examine_management.service.OvertimeaskVoService;
import com.trkj.balance.modules.examine_management.vo.OvertimeaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OvertimeaskVoImpl extends ServiceImpl<OvertimeaskVoMapper, OvertimeaskVo> implements OvertimeaskVoService {

    //加班详情
    @Autowired
    private OvertimeaskVoMapper overtimeaskVoMapper;

    @Override
    public List<OvertimeaskVo> findSelectByIdOvertimeask(Long id) {
        return overtimeaskVoMapper.findSelectByIdOvertimeask(id);
    }
}
