package com.trkj.balance.modules.organization_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import com.trkj.balance.modules.organization_management.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.organization_management.vo.DeptStaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2022-01-10
 */
@Mapper
public interface Staff_DeptMapper extends BaseMapper<DeptStaffVo> {
    @Select("select a.STAFF_ID,a.STAFF_NAME,a.STAFF_SEX,a.STAFF_EDUCATION,a.STAFF_PHONE,b.POSITION_NAME,c.DEPT_NAME\n" +
            "from\n" +
            "STAFF a\n" +
            "left join\n" +
            "POSITION b\n" +
            "on a.POSITION_ID=b.POSITION_ID\n" +
            "left join\n" +
            "DEPT c\n" +
            "on a.DEPT_ID=c.DEPT_ID " +
            "${ew.customSqlSegment}")
    IPage<DeptStaffVo> yg(Page<DeptStaffVo>page,@Param(Constants.WRAPPER) QueryWrapper<DeptStaffVo> queryWrapper);

}
