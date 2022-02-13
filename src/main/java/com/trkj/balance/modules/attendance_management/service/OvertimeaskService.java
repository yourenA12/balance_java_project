package com.trkj.balance.modules.attendance_management.service;

import com.trkj.balance.modules.attendance_management.entity.Overtimeask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 加班表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-18
 */
public interface OvertimeaskService extends IService<Overtimeask> {

    //删除
    public int Overtdelete(Long id);


}
