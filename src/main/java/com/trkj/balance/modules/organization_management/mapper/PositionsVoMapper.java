package com.trkj.balance.modules.organization_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import com.trkj.balance.modules.organization_management.vo.PositionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PositionsVoMapper extends BaseMapper<PositionVo> {

    @Select("select a.DEPT_POST_ID,b.DEPT_ID,b.DEPT_NAME,c.POSITION_ID,c.POSITION_NAME,c.POSITION_DESCRIPTION\n" +
            "from\n" +
            "DEPT_POST a\n" +
            "left join\n" +
            "DEPT b\n" +
            "on a.DEPT_ID=b.DEPT_ID\n" +
            "left join\n" +
            "POSITION c\n" +
            "on a.POSITION_ID=c.POSITION_ID\n" +
            "where c.POSITION_ID=#{Id}" +
            "${ew.customSqlSegment}")
    IPage<PositionVo> slposition(Page<PositionVo> page, @Param(Constants.WRAPPER) QueryWrapper<PositionVo> queryWrapper);

    @Select("select a.DEPT_POST_ID,b.DEPT_ID,b.DEPT_NAME,c.POSITION_ID,c.POSITION_NAME,c.POSITION_DESCRIPTION\n" +
            "from\n" +
            "DEPT_POST a\n" +
            "left join\n" +
            "DEPT b\n" +
            "on a.DEPT_ID=b.DEPT_ID\n" +
            "left join\n" +
            "POSITION c\n" +
            "on a.POSITION_ID=c.POSITION_ID\n" +
            "where c.POSITION_ID=#{Id}")
    List<PositionVo> selectPosition(Long id);


}
