package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.travelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TravelNVoMapper extends BaseMapper<travelVo> {
    @Select("SELECT AA.STAFF_NAME AS STAFF_NAME1,AB.STAFF_NAME AS STAFF_NAME2,B.AUDITFLOWDETAI_STATE,D.DEPT_NAME,C.TRAVEL_PLACE,C.TRAVEL_MATTER,\n" +
            "C.TRAVEL_S_DATE,C.TRAVEL_E_DATE,C.TRAVEL_TOTAL_DATE,D.DEPT_ID \n" +
            "FROM \n" +
            "AUDITFLOW A\n" +
            "LEFT JOIN\n" +
            "AUDITFLOWDETAIL B\n" +
            "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
            "LEFT JOIN STAFF AA ON AA.STAFF_ID = A.STAFF_ID\n" +
            "LEFT JOIN STAFF AB ON AB.STAFF_ID = B.STAFF_ID\n" +
            "LEFT JOIN TRAVEL C ON A.AUDITFLOW_ID = C.AUDITFLOW_ID\n" +
            "LEFT JOIN DEPT D ON AA.DEPT_ID = D.DEPT_ID\n" +
            "WHERE A.AUDITFLOW_ID = #{id}")
    List<travelVo> findSelectTravelVoById(@Param("id") Long id);

}
