package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
    int insertCompensation(Compensation compensation, ArrayList<Integer> deptIds, ArrayList<Integer> postIds,ArrayList<Integer> staffIds );

    //查询薪酬组名称
    List<Map<String, Object>> selectCompensationName();

    //根据id查询薪酬组数据
    Compensation selectCompensationById(Long id);

    //修改薪酬组数据
    int updateCompensation(Compensation compensation);

    //根据薪酬组名称查询
    String selectCompensationNames(String name);

    //查询薪酬组
    IPage<Compensation> selectCompensationPage(IPage<Compensation> page);


    // 按薪酬组id查询部门id
    List<Integer> selectDeptId(int id);

    // 按薪酬组id查询部门id
    List<Integer> selectPostId(int id);

    // 按薪酬组id查询员工
    List<Integer> selectStaffId(int id);


    //删除薪酬组
    int deleteCompensation(Long id);

    // 按薪酬组查询 方案 （加班方案id，扣款方案id，出差方案id）
    Compensation selectCompensation(Long id);

}
