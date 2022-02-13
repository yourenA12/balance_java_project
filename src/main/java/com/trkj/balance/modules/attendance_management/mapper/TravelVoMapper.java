package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.LeaveVo;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TravelVoMapper extends BaseMapper<TravelVo> {
    @Select("select a.TRAVEL_ID,a.STAFF_ID,c.STAFF_NAME,a.DEPT_ID,a.TRAVEL_PLACE,a.TRAVEL_MATTER,a.TRAVEL_S_DATE,a.TRAVEL_E_DATE,a.TRAVEL_TOTAL_DATE,b.DEPT_NAME\n" +
            "from\n" +
            "TRAVEL a\n" +
            "left join\n" +
            "DEPT b\n" +
            "on a.DEPT_ID=b.DEPT_ID\n" +
            "left join\n" +
            "STAFF c\n" +
            "on a.STAFF_ID=c.STAFF_ID " +
            "${ew.customSqlSegment}")
    IPage<TravelVo> selectTravel (Page<TravelVo> page,@Param(Constants.WRAPPER) QueryWrapper<TravelVo> queryWrapper);

}
