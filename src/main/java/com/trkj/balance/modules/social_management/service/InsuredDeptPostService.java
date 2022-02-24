package com.trkj.balance.modules.social_management.service;

import com.trkj.balance.modules.social_management.entity.InsuredDeptPost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 * 参保方案部门职位中间表 服务类
 * </p>
 *
 * @author 友人A
 * @since 2022-02-22
 */
public interface InsuredDeptPostService extends IService<InsuredDeptPost> {

    // 根据部门id和职位id，查询参保方案部门职位中间表有无数据，
    String selectInsuredDeptPost(ArrayList<Integer> deptIds, ArrayList<Integer> postIds);

}
