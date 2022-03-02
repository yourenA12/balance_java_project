package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.QuitnVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuitVoMapper extends BaseMapper<QuitnVo> {
    //更具id 查询离职详情
    @Select("SELECT a.AUDITFLOW_ID,ac.STAFF_NAME AS STAFF_NAME1,bc.STAFF_NAME AS STAFF_NAME2,C.QUIT_EXPLAIN,C.APPLY_QUIT_DATE,D.DEPT_NAME,C.APPLY_QUIT_DATE,B.AUDITFLOWDETAI_STATE\n" +
            "FROM\n" +
            "AUDITFLOW A\n" +
            "LEFT JOIN\n" +
            "AUDITFLOWDETAIL B\n" +
            "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
            "LEFT JOIN\n" +
            "QUIT C\n" +
            "ON A.AUDITFLOW_ID = C.AUDITFLOW_ID\n" +
            "LEFT JOIN \n" +
            "DEPT D \n" +
            "ON C.DEPT_ID = D.DEPT_ID\n" +
            "\tleft join staff ac on a.STAFF_ID=ac.STAFF_ID\n" +
            "\t\tleft join staff bc on b.STAFF_ID=bc.STAFF_ID\n" +
            "WHERE A.AUDITFLOW_ID=#{id}")
    List<QuitnVo> findSelectById(@Param("id")Long id);

}
