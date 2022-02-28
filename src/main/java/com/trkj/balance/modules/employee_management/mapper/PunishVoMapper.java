package com.trkj.balance.modules.employee_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.entity.Punish;
import com.trkj.balance.modules.employee_management.vo.PunishVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PunishVoMapper extends BaseMapper<PunishVo> {

    @Select("select * from Punish p left JOIN staff s on p.STAFF_ID=s.STAFF_ID LEFT JOIN dept d on s.DEPT_ID=d.DEPT_ID  ${ew.customSqlSegment}")
    IPage<PunishVo> selectPunishPage(IPage<PunishVo> page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}
