package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.entity.Workscheme;

/**
 * <p>
 * 出差方案表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-13
 */
public interface BusinessService extends IService<Business> {

    //新增出差方案
    int insertBusiness(Business business);

    //查询出差方案
    IPage<Business> selectBusiness(Page<Business> page);

    //修改出差方案状态
    int updateBusinessState(Business business);

    //删除出差方案
    int deleteBusiness(Long id);

    //根据id查询出差方案信息
    Business selectBusinessId(Long id );

    //修改出差方案
    int updateBusiness(Business business);



}
