package com.trkj.balance.modules.salary_management.service;

import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 薪酬组表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
public interface CompensationService extends IService<Compensation> {

    //添加薪酬组
    int insertCompensation(Compensation compensation, ArrayList<Integer> deptIds, ArrayList<Integer> postIds );

    //查询薪酬组名称
    List<Map<String, Object>> selectCompensationName();

    //根据id查询薪酬组数据
    Compensation selectCompensationById(Long id);

}
