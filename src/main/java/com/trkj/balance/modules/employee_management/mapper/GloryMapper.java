package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.entity.Glory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 荣誉/奖励表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-01-04
 */
@Mapper
public interface GloryMapper extends BaseMapper<Glory> {

    //分页查询奖励表
    @Select("select * from GLORY g left JOIN staff s on g.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on s.DEPT_ID=d.DEPT_ID  ${ew.customSqlSegment}")
    IPage<Glory> selectGloryPage(IPage<Glory> page,@Param(Constants.WRAPPER) QueryWrapper wrapper);


}
