package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.QuitnVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuitVoMapper extends BaseMapper<QuitnVo> {
    @Select("SELECT A.AUDITFLOW_ID,A.STAFF_NAME AS STAFF_NAME1,b.STAFF_NAME AS STAFF_NAME2,C.QUIT_EXPLAIN,C.APPLY_QUIT_DATE,D.DEPT_NAME,C.APPLY_QUIT_DATE\n" +
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
            "WHERE A.AUDITFLOW_ID=#{id}")
    List<QuitnVo> findSelectById(@Param("id")Long id);

}
