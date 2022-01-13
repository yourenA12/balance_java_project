package com.trkj.balance.modules.attendance_management.service.impl;

import com.trkj.balance.modules.attendance_management.entity.ClockRecord;
import com.trkj.balance.modules.attendance_management.mapper.ClockRecordMapper;
import com.trkj.balance.modules.attendance_management.service.ClockRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 打卡记录表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-06
 */
@Service
public class ClockRecordServiceImpl extends ServiceImpl<ClockRecordMapper, ClockRecord> implements ClockRecordService {

    @Autowired
    private ClockRecordMapper clockRecordMapper;

    @Override
    public int Clodelete(Long id) {
        return clockRecordMapper.deleteById(id);
    }
}
