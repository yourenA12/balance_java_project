package com.trkj.balance.modules.attendance_management.service;

import com.trkj.balance.modules.attendance_management.entity.Leave;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-22
 */
public interface LeaveService extends IService<Leave> {
    //删除
    public int Leavedelete(Long id);

}
