package com.trkj.balance.modules.login.service;

import com.trkj.balance.modules.login.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2021-12-28
 */
public interface StaffService extends IService<Staff> {
    List<Staff> list();
}
