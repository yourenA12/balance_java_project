package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffVoMapper extends BaseMapper<StaffVo> {

   //分页查询员工状态为正式和试用的员工
    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID \n" +
            "            left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID\n" +
            "            ${ew.customSqlSegment}")
    IPage<StaffVo> selectStaffVo (Page<StaffVo> page, @Param(Constants.WRAPPER) QueryWrapper<StaffVo> wrapper);

 //查询员工状态为正式和试用的员工  查询员工的姓名、部门、名称

    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID where s.STAFF_STATE=2 or s.STAFF_STATE=3")
    List<StaffVo> selectStaffXX();

    //员工页面 编辑按钮 根据id查询员工信息
    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID where s.STAFF_ID=#{id}" )
    StaffVo selectStaffId(@Param("id") Long id);

    //转正管理 查询试用期人员
    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID where s.STAFF_STATE=2")
    IPage<StaffVo> selectProbation (Page<StaffVo> page);

    //历史花名册 查询状态为离职的员工
    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID LEFT JOIN QUIT q on s.STAFF_ID=q.STAFF_ID  ${ew.customSqlSegment}")
    IPage<StaffVo> selectStaffHistorical (Page<StaffVo> page,@Param(Constants.WRAPPER) QueryWrapper<StaffVo> wrapper);
}
