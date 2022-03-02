package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.OvertimeaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//加班详情
@Mapper
public interface OvertimeaskVoMapper extends BaseMapper<OvertimeaskVo> {
    @Select("SELECT AA.STAFF_NAME AS STAFF_NAME1,AB.STAFF_NAME AS STAFF_NAME2,B.AUDITFLOWDETAI_STATE,C.OVERTIMEASK_TYPE,C.OVERTIMEASK_S_DATE,C.OVERTIMEASK_E_DATE,C.OVERTIMEASK_TOTAL_DATE,OVERTIMEASK_MATTER\n" +
            "FROM \n" +
            "AUDITFLOW A\n" +
            "LEFT JOIN\n" +
            "AUDITFLOWDETAIL B\n" +
            "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
            "LEFT JOIN STAFF AA ON AA.STAFF_ID = A.STAFF_ID\n" +
            "LEFT JOIN STAFF AB ON AB.STAFF_ID = B.STAFF_ID\n" +
            "LEFT JOIN OVERTIMEASK C ON A.AUDITFLOW_ID = C.AUDITFLOW_ID\n" +
            "WHERE A.AUDITFLOW_ID = #{id}\n")
    List<OvertimeaskVo> findSelectByIdOvertimeask(@Param("id") Long id);
}
