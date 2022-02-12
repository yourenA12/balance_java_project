package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.LeaveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LeaveVoMapper extends BaseMapper<LeaveVo> {
    @Select("select a.LEAVE_ID,a.STAFF_ID,c.STAFF_NAME,a.DEPT_ID,a.LEAVE_TYPE,a.LEAVE_MATTER,a.LEAVE_S_DATE,a.LEAVE_E_DATE,a.LEAVE_TOTAL_DATE,b.DEPT_NAME\n" +
            "from\n" +
            "LEAVE a\n" +
            "left join\n" +
            "DEPT b\n" +
            "on a.DEPT_ID=b.DEPT_ID\n" +
            "left join\n" +
            "STAFF c\n" +
            "on a.STAFF_ID=c.STAFF_ID\n" +
            "${ew.customSqlSegment}")
    IPage<LeaveVo> selsectLeave (Page<LeaveVo> page,@Param(Constants.WRAPPER) QueryWrapper<LeaveVo> queryWrapper );
}
