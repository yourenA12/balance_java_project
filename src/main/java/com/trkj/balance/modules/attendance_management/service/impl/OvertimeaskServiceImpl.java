package com.trkj.balance.modules.attendance_management.service.impl;

import com.trkj.balance.modules.attendance_management.entity.Overtimeask;
import com.trkj.balance.modules.attendance_management.mapper.OvertimeaskMapper;
import com.trkj.balance.modules.attendance_management.service.OvertimeaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 加班表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-18
 */
@Service
public class OvertimeaskServiceImpl extends ServiceImpl<OvertimeaskMapper, Overtimeask> implements OvertimeaskService {

    @Autowired
    public OvertimeaskMapper overtimeaskMapper;

    //删除
    @Override
    public int Overtdelete(Long id) {
        return overtimeaskMapper.deleteById(id);
    }
}
