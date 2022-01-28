package com.trkj.balance.modules.system_managementTest.service;

import com.trkj.balance.modules.system_managementTest.entity.Deptp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-16
 */
public interface DeptpService extends IService<Deptp> {

    List<Deptp> queryList();

}
