package com.trkj.balance.modules.salary_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.salary_management.Vo.WagVo;
import com.trkj.balance.modules.salary_management.entity.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WageVoMapper extends BaseMapper<WagVo> {

    //查询工资表
    @Select("select c.STAFF_ID,c.STAFF_NAME,d.DEPT_NAME,e.POSITION_NAME,c.STAFF_STATE,f.FIXEDWAGE_PERIODMONEY,f.FIXEDWAGE_OFFICIALMONEY\n" +
            ",g.INS_DETAIL_SOCIAL_PERSON_PAY,g.INS_DETAIL_SOCIAL_FIRM_PAY,g.INS_DETAIL_FUND_PERSON_PAY,g.INS_DETAIL_FUND_FIRM_PAY\n" +
            "from  COMPENSATION a \n" +
            "RIGHT JOIN COMPENSATION_STAFF b on a.COMPENSATION_ID=b.COMPENSATION_ID \n" +
            "LEFT JOIN STAFF c on b.STAFF_ID=c.STAFF_ID\n" +
            "LEFT JOIN DEPT d on d.DEPT_ID=c.DEPT_ID\n" +
            "LEFT JOIN POSITION e on e.POSITION_ID=c.POSITION_ID\n" +
            "LEFT JOIN FIXEDWAGE f on c.STAFF_ID=f.STAFF_ID\n" +
            "LEFT JOIN INSURED_DETAIL g on c.STAFF_ID=g.STAFF_ID ${ew.customSqlSegment}"
            )
      IPage<WagVo> selectWagVo(IPage<WagVo> page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}
