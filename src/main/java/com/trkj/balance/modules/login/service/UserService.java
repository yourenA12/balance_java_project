package com.trkj.balance.modules.login.service;

import com.trkj.balance.modules.login.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-03-02
 */
public interface UserService extends IService<Staff> {

    // 登录
    Staff toLogin(Staff staff);

    // 修改面
    int changePass(Staff staff);


}
