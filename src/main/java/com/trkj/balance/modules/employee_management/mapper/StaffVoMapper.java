package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.trkj.balance.modules.employee_management.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffVoMapper extends BaseMapper<StaffVo> {
    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  DEPT_POST dp on s.DEPT_POST_ID=dp.DEPT_POST_ID")
    IPage<StaffVo> selectStaffVo (Page<StaffVo> page);

    @Select("select * from staff s LEFT JOIN dept d on s.DEPT_ID=d.DEPT_ID LEFT JOIN DEPT_POST dp on s.DEPT_POST_ID=dp.DEPT_POST_ID where s.STAFF_ID=#{id}")
    StaffVo selectStaffId(@Param("id") Long id);
}
