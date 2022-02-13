package com.trkj.balance.modules.attendance_management.service.impl;

import com.trkj.balance.modules.attendance_management.entity.Leave;
import com.trkj.balance.modules.attendance_management.mapper.LeaveMapper;
import com.trkj.balance.modules.attendance_management.service.LeaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请假表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-22
 */
@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {
    @Autowired
    public LeaveMapper leaveMapper;

    @Override
    public int Leavedelete(Long id) {
        return leaveMapper.deleteById(id);
    }
}
