package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.attendance_management.entity.ClockRecord;

/**
 * <p>
 * 打卡记录表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-06
 */
public interface ClockRecordService extends IService<ClockRecord> {

    //删除
    public int Clodelete(Long id);

}



