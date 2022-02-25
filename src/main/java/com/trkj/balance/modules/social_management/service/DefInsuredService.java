package com.trkj.balance.modules.social_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.social_management.entity.DefScheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 默认参保方案表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
public interface DefInsuredService extends IService<DefInsured> {

    // 查询所有参保方案
    IPage<DefInsured> selectAllPage(Page page,String name,Object state);

    // 删除参保方案
    int deleteDefInsured(Long id);

    // 修改参保方案状态
    int updateDefInsuredState(DefInsured defInsured);

    // 新增参保方案
    int insertDefInsured(DefInsured defInsured, List<DefScheme> defScheme,
                         int upper, int lower, List<Integer> deptIds,
                         List<Integer> postIds,List<Integer> staffIds);


    // 按参保方案id查询参保方案
    DefInsured selectDefInsuredById(int id);

    // 按参保方案id查询方案
    List<DefScheme> selectDefSchemeById(int id);

    // 按参保方案id查询部门id
    List<Integer> selectDeptId(int id);

    // 按参保方案id查询部门id
    List<Integer> selectPostId(int id);

    // 按参保方案id查询员工
    List<Integer> selectStaffId(int id);

    // 按id删除参保方案
    int deleteById(int id);


    //根据参保方案名称查询
    String selectDefInsuredNames(String name);



}
