package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;
import com.trkj.balance.modules.social_management.vo.socialStaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InsuredDetailVoMapper extends BaseMapper<InsuredDetailVo> {

    // 查询社保缴费明细
    @Select("select * from INSURED_DETAIL a \n" +
            "LEFT JOIN STAFF b on a.STAFF_ID=b.STAFF_ID\n" +
            "LEFT JOIN INSURED_STAFF c on c.STAFF_ID=b.STAFF_ID\n" +
            "LEFT JOIN DEF_INSURED d on c.DEF_INSURED_ID=d.DEF_INSURED_ID ${ew.customSqlSegment} and TO_CHAR(a.CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM')")
    IPage<InsuredDetailVo> selectInsuredDetail(IPage<InsuredDetailVo> page,@Param(Constants.WRAPPER) QueryWrapper<InsuredDetailVo> wrapper);

}
