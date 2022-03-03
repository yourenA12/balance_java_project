package com.trkj.balance.modules.social_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import com.trkj.balance.modules.social_management.entity.InsuredDetailSon;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 友人A
 * @since 2022-02-28
 */
@Mapper
public interface InsuredDetailSonMapper extends BaseMapper<InsuredDetailSon> {

    // 按员工id查询社保缴费明细详情 （传月份）
    @Select("SELECT * FROM  INSURED_DETAIL_SON WHERE STAFF_ID=#{id} AND TO_CHAR(CREATED_TIME,'yyyy-MM')=TO_CHAR(TO_DATE(#{date},'yyyy-MM'),'yyyy-MM')")
    List<InsuredDetailSon> selectByIdByDate(@Param("id") Long id,@Param("date") String date);

    // 按员工id和当前月份删除参保明细表
    @Delete("DELETE FROM INSURED_DETAIL_SON ${ew.customSqlSegment} AND TO_CHAR(CREATED_TIME,'yyyy-MM') = TO_CHAR(SYSDATE,'yyyy-MM')")
    int deleteByDate(@Param(Constants.WRAPPER) QueryWrapper<EntryhirdeVo> wrapper);

}
