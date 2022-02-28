package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.trkj.balance.modules.employee_management.vo.GloryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GloryVoMapper extends BaseMapper<GloryVo> {

    //分页查询奖励表
    @Select("select * from GLORY g left JOIN staff s on g.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on s.DEPT_ID=d.DEPT_ID  ${ew.customSqlSegment}")
    IPage<GloryVo> selectGloryPage(IPage<GloryVo> page, @Param(Constants.WRAPPER) QueryWrapper wrapper);


}
