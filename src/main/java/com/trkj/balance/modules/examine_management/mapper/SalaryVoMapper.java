package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.SalaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryVoMapper extends BaseMapper<SalaryVo> {
    //调薪详情查询
    @Select("SELECT AA.STAFF_NAME AS STAFF_NAME1,C.SALARY_CAUSE,AB.STAFF_NAME AS STAFF_NAME2,D.DEPT_NAME,C.FRONT_SALARY,C.AFTER_SALARY,C.SALARY_REMARKS,\n" +
            "C.TAKE_EFFECT_DATE,B.AUDITFLOWDETAI_STATE FROM\n" +
            "AUDITFLOW A\n" +
            "LEFT JOIN\n" +
            "AUDITFLOWDETAIL B\n" +
            "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
            "LEFT JOIN STAFF AA ON AA.STAFF_ID = A.STAFF_ID\n" +
            "LEFT JOIN STAFF AB ON AB.STAFF_ID = B.STAFF_ID\n" +
            "LEFT JOIN SALARY C ON A.AUDITFLOW_ID = C.AUDITFLOW_ID\n" +
            "LEFT JOIN DEPT D ON D.DEPT_ID = AA.DEPT_ID\n" +
            "WHERE A.AUDITFLOW_ID = #{id}")
    List<SalaryVo> finSelectSalarById(@Param("id")Long id);
}
