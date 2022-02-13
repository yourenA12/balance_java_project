package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.OvertVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OvertVoMapper extends BaseMapper<OvertVo> {
    @Select("select a.OVERTIMEASK_ID,a.STAFF_ID,c.STAFF_NAME,a.DEPT_ID,a.OVERTIMEASK_TYPE,a.OVERTIMEASK_MATTER,a.OVERTIMEASK_S_DATE,a.OVERTIMEASK_E_DATE,a.OVERTIMEASK_TOTAL_DATE,a.OVERTIMEASK_STATE,a.UPDATED_TIME,b.DEPT_NAME\n" +
            "from\n" +
            "OVERTIMEASK a\n" +
            "left join\n" +
            "DEPT b\n" +
            "on a.DEPT_ID=b.DEPT_ID\n" +
            "left join\n" +
            "STAFF c\n" +
            "on a.STAFF_ID=c.STAFF_ID " +
            "${ew.customSqlSegment}")
    IPage<OvertVo> selectOvert (Page<OvertVo> page, @Param(Constants.WRAPPER) QueryWrapper<OvertVo> queryWrapper);



}
