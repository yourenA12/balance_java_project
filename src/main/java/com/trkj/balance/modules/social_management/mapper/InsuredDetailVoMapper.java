package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InsuredDetailVoMapper extends BaseMapper<InsuredDetailVo> {

    // 查询社保缴费明细
    @Select("select * from INSURED_DETAIL a \n" +
            "LEFT JOIN STAFF b on a.STAFF_ID=b.STAFF_ID LEFT JOIN dept de on b.DEPT_ID=de.DEPT_ID left JOIN  POSITION p  on b.POSITION_ID=p.POSITION_ID\n" +
            "RIGHT JOIN INSURED_STAFF c on c.STAFF_ID=b.STAFF_ID\n" +
            "LEFT JOIN DEF_INSURED d on c.DEF_INSURED_ID=d.DEF_INSURED_ID ${ew.customSqlSegment} and TO_CHAR(a.CREATED_TIME,'yyyy-MM')=TO_CHAR(sysdate,'yyyy-MM')")
    IPage<InsuredDetailVo> selectInsuredDetail(IPage<InsuredDetailVo> page,@Param(Constants.WRAPPER) QueryWrapper<InsuredDetailVo> wrapper);

    //查询参保明细
    @Select("select b.STAFF_NAME,c.DEPT_NAME,d.POSITION_NAME,e.DEF_INSURED_NAME,f.INS_DETAIL_SOCIAL_PERSON_PAY\n" +
            ",f.INS_DETAIL_SOCIAL_FIRM_PAY,f.INS_DETAIL_FUND_PERSON_PAY,f.INS_DETAIL_FUND_FIRM_PAY,TO_CHAR(a.CREATED_TIME,'yyyy-MM') as insuredMonth\n" +
            "from INSURED_STAFF a \n" +
            "LEFT JOIN STAFF b on a.STAFF_ID=b.STAFF_ID\n" +
            "LEFT JOIN DEPT c on c.DEPT_ID=b.DEPT_ID\n" +
            "LEFT JOIN POSITION d on d.POSITION_ID=b.POSITION_ID\n" +
            "LEFT JOIN DEF_INSURED e on a.DEF_INSURED_ID=e.DEF_INSURED_ID\n" +
            "LEFT JOIN INSURED_DETAIL f on b.STAFF_ID=f.STAFF_ID\n" +
            "where a.STAFF_ID =#{id}")

    InsuredDetailVo selectInsuredDetailVo(Long id);
}
