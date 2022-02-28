package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.social_management.entity.InsuredStaff;
import com.trkj.balance.modules.social_management.vo.socialStaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface socialStaffMapper extends BaseMapper<socialStaffVo> {

    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID ${ew.customSqlSegment}")
    IPage<socialStaffVo> selectSocialPage(IPage<socialStaffVo> page,@Param(Constants.WRAPPER) QueryWrapper<socialStaffVo> wrapper);
}
