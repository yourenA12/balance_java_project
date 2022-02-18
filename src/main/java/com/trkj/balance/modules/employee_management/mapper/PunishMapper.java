package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 惩罚表 Mapper 接口
 * </p>
 *
 * @author 林落。
 * @since 2022-01-04
 */
@Mapper
public interface PunishMapper extends BaseMapper<Punish> {

    @Select("select * from Punish p left JOIN staff s on p.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on s.DEPT_ID=d.DEPT_ID  ${ew.customSqlSegment}")
    IPage<Punish> selectPunishPage(IPage<Punish> page,@Param(Constants.WRAPPER) QueryWrapper wrapper);
}
