package com.trkj.balance.modules.salary_management.service;

import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 薪酬组部门职位中间表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
public interface CompensationDeptPostService extends IService<CompensationDeptPost> {

    // 根据部门id和职位id，查询薪酬组部门职位中间表有无数据，
    String selectCompensationDeptPost(ArrayList<Integer> deptIds, ArrayList<Integer> postIds);

}
