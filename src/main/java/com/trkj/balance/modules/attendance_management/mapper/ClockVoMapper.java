package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.attendance_management.vo.ClockVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClockVoMapper extends BaseMapper<ClockVo> {

    @Select("select a.CLOCK_RECORD_ID,b.STAFF_NAME,c.DEPT_NAME,a.MORN_CLOCK,a.AFTERNOON_CLOCK,a.UPDATED_TIME\n" +
            "from CLOCK_RECORD a \n" +
            "LEFT JOIN staff b on a.STAFF_ID = b.STAFF_ID\n" +
            "LEFT JOIN dept c on a.DEPT_ID = c.DEPT_ID " +
            "${ew.customSqlSegment}")
    IPage<ClockVo> selectClok1 (IPage<ClockVo> page,@Param(Constants.WRAPPER) QueryWrapper<ClockVo> queryWrapper);



}
