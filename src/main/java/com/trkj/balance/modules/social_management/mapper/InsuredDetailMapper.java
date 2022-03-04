package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.social_management.entity.InsuredDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 参保明细表 Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-02-27
 */
@Mapper
public interface InsuredDetailMapper extends BaseMapper<InsuredDetail> {

    // 按员工id和当前月份删除参保明细表
    @Delete("DELETE FROM INSURED_DETAIL ${ew.customSqlSegment} AND TO_CHAR(CREATED_TIME,'yyyy-MM') = TO_CHAR(SYSDATE,'yyyy-MM')")
    int deleteByDate(@Param(Constants.WRAPPER) QueryWrapper wrapper);

    //根据员工id查询参保明细
    @Select("SELECT TO_CHAR(CREATED_TIME,'yyyy-MM') as insuredMonth,INS_DETAIL_SOCIAL_PERSON_PAY," +
            "INS_DETAIL_SOCIAL_FIRM_PAY,INS_DETAIL_FUND_PERSON_PAY,INS_DETAIL_FUND_FIRM_PAY " +
            "FROM  INSURED_DETAIL WHERE STAFF_ID=#{id} ORDER BY CREATED_TIME desc")
    IPage<InsuredDetail> selectInsuredDetailPage(IPage<InsuredDetail> page,@Param("id") Long id);
}
