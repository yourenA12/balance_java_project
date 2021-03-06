package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.social_management.vo.SocialStaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SocialStaffMapper extends BaseMapper<SocialStaffVo> {

    @Select("select * from staff s left JOIN dept d on s.DEPT_ID=d.DEPT_ID left JOIN  POSITION p  on s.POSITION_ID=p.POSITION_ID ${ew.customSqlSegment}")
    IPage<SocialStaffVo> selectSocialPage(IPage<SocialStaffVo> page, @Param(Constants.WRAPPER) QueryWrapper<SocialStaffVo> wrapper);
}
