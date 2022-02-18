package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.entity.Worker;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 转正 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-12
 */
public interface Worker_StaffService extends IService<Worker> {

    //添加转正表和修改员工表的转正日期、员工状态
   int insertWorker(Worker worker, Staff staff);

}
