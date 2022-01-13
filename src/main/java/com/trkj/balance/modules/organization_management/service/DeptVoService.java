package com.trkj.balance.modules.organization_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.organization_management.vo.DeptVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-11
 */
public interface DeptVoService extends IService<DeptVo> {

    // 分页查询所有部门
    IPage<DeptVo> selectDeptVo(Page<DeptVo> page);



}
