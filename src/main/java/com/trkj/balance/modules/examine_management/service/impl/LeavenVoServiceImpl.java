package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.LeavenVoMapper;
import com.trkj.balance.modules.examine_management.service.LeavenVoService;
import com.trkj.balance.modules.examine_management.vo.LeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavenVoServiceImpl extends ServiceImpl<LeavenVoMapper, LeaveVo> implements LeavenVoService {
    @Autowired
    private LeavenVoMapper leavenVoMapper;
    //请假审批
    @Override
    public List<LeaveVo> findeSeelectById(Long id) {
        return leavenVoMapper.findeSeelectById(id);
    }
}
