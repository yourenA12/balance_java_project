package com.trkj.balance.modules.attendance_management.service;

import com.trkj.balance.modules.attendance_management.entity.Travel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 出差表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-23
 */
public interface TravelService extends IService<Travel> {
    //删除
    public int Traveldelete(Long id);

}
