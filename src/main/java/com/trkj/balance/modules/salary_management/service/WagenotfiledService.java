package com.trkj.balance.modules.salary_management.service;

import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工资未归档表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-03-03
 */
public interface WagenotfiledService extends IService<Wagenotfiled> {

    //修改工资状态为归档
    int updateWagenotfiledVo(Wagenotfiled wagenotfiled);

}
