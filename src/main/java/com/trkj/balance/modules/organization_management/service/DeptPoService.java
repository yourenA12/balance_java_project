package com.trkj.balance.modules.organization_management.service;

import com.trkj.balance.modules.organization_management.entity.DeptPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.organization_management.entity.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * <p>
 * 部门职位中间表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-03-01
 */
public interface DeptPoService extends IService<DeptPost> {

    //新增
    int insert(Position post, ArrayList<Integer> deptIds);

}
