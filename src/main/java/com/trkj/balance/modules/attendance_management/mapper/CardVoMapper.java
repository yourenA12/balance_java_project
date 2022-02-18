package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.CardVo;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CardVoMapper extends BaseMapper<CardVo> {
    @Select("select a.CARD_ID,a.STAFF_ID,b.STAFF_NAME,a.CARD_TYPE,a.CARD_DATE,a.CARD_REMARKS,c.DEPT_NAME\n" +
            "from\n" +
            "CARD a\n" +
            "left join \n" +
            "STAFF b \n" +
            "on a.STAFF_ID=b.STAFF_ID\n" +
            "left join\n" +
            "DEPT c\n" +
            "on b.STAFF_ID=C.DEPT_ID " +
            "${ew.customSqlSegment}")
    IPage<CardVo> selectCart (Page<CardVo>page,@Param(Constants.WRAPPER) QueryWrapper<CardVo> queryWrapper);
}
