package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;
import com.trkj.balance.modules.social_management.vo.InsuredMonthVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InsuredMonthVoMapper extends BaseMapper<InsuredMonthVo> {

    @Select("select TO_CHAR(CREATED_TIME,'yyyy-MM') as insuredMonth,COUNT(STAFF_ID) as insuredNumber,sum(INS_DETAIL_SOCIAL_PERSON_PAY+INS_DETAIL_FUND_PERSON_PAY) as Individual\n" +
            ",sum(INS_DETAIL_SOCIAL_FIRM_PAY+INS_DETAIL_FUND_FIRM_PAY) as companies\n" +
            "from INSURED_DETAIL\n" +
            "GROUP BY TO_CHAR(CREATED_TIME,'yyyy-MM') ORDER BY TO_CHAR(CREATED_TIME,'yyyy-MM') desc")

    List<InsuredMonthVo> selectInsuredMonthVo();
}
