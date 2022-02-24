package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.TransferVo;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransferVoMapper extends BaseMapper<TransferVo> {
    //更具id 查询人事异动详情信息
    @Select("SELECT A.AUDITFLOW_ID,E.STAFF_NAME AS STAFF_NAME1,EE.STAFF_NAME AS STAFF_NAME2,C.TRANSFER_TYPE,C.CREATED_DEPT_ID,C.UPDATED_DEPT_ID,C.TRANSFER_STATE,C.TRANSFER_RAWPOST_ID,C.TRANSFER_AFTERPOST_ID,E.POSITION_ID,f.POSITION_NAME,d.dept_name,d1.dept_name as dept_name1\n" +
            "FROM AUDITFLOW A\n" +
            "LEFT JOIN \n" +
            "AUDITFLOWDETAIL B\n" +
            "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
            "LEFT JOIN \n" +
            "TRANSFER C\n" +
            "ON A.AUDITFLOW_ID = C.AUDITFLOW_ID\n" +
            "LEFT JOIN\n" +
            "DEPT D\n" +
            "ON C.CREATED_DEPT_ID = D.DEPT_ID\n" +
            "LEFT JOIN\n" +
            "DEPT d1\n" +
            "ON C.UPDATED_DEPT_ID = d1.DEPT_ID\n" +
            "LEFT JOIN\n" +
            "STAFF E\n" +
            "ON E.STAFF_ID = A.STAFF_ID\n" +
            "LEFT JOIN\n" +
            "STAFF EE\n" +
            "ON EE.STAFF_ID = B.STAFF_ID\n" +
            "left join\n" +
            "POSITION F\n" +
            "on f.POSITION_ID = e.POSITION_ID\n" +
            "where a.AUDITFLOW_id=#{id}\n" +
            "ORDER BY d.CREATED_TIME")
    List<TransferVo> findSelectTranseferById(@Param("id") Long id);

}
