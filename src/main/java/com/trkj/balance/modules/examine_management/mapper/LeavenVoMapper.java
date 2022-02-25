package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.LeaveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface LeavenVoMapper extends BaseMapper<LeaveVo> {
       @Select("SELECT A.AUDITFLOW_ID,A.AUDITFLOW_TYPE,Ac.STAFF_NAME AS STAFF_NAME1,Bc.STAFF_NAME AS STAFF_NAME2,C.LEAVE_S_DATE,C.LEAVE_E_DATE,C.\t\t\t\t\t\t\tLEAVE_TOTAL_DATE,\n" +
               "C.LEAVE_REMARKS,B.AUDITFLOWDETAI_STATE\n" +
               "FROM\n" +
               "AUDITFLOW A\n" +
               "LEFT JOIN\n" +
               "AUDITFLOWDETAIL B\n" +
               "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
               "LEFT JOIN \n" +
               "LEAVE C\n" +
               "ON A.AUDITFLOW_ID = C.AUDITFLOW_ID\n" +
               "\t\tleft join staff ac on a.STAFF_ID=ac.STAFF_ID\n" +
               "\t\tleft join staff bc on b.STAFF_ID=bc.STAFF_ID\n" +
               "WHERE A.AUDITFLOW_ID=#{id}")
    List<LeaveVo> findeSeelectById(@Param("id") Long id);
}
