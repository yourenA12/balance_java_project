package com.trkj.balance.modules.employee_management.service;

import com.trkj.balance.modules.employee_management.entity.Quit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.entity.Staff;

/**
 * <p>
 * 离职表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-01-08
 */
public interface Quit_StaffService extends IService<Quit> {

    //员工办理离职 添加离职表和修改员工状态
    int insertDimission(Quit quit, Staff staff);

}
