package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.*;

@Mapper
public interface WorkerVoMapper extends BaseMapper<WorkerVo> {
    /*通过id 查询 详情信息*/
    @Select("select\n" +
            "        a.AUDITFLOW_ID,\n" +
            "        e.staff_name as staff_name1,\n" +
            "        ee.staff_name as staff_name2,\n" +
            "        c.worker_date,\n" +
            "        a.auditflow_state,\n" +
            "        dept_name,\n" +
            "        c.WORKER_TYPE,\n" +
            "        c.WORKER_REMARKS,\n" +
            "        b.AUDITFLOWDETAI_STATE \n" +
            "    from\n" +
            "        AUDITFLOW a \n" +
            "    left join\n" +
            "        AUDITFLOWDETAIL b \n" +
            "            on a.AUDITFLOW_ID = b.AUDITFLOW_ID \n" +
            "    left join\n" +
            "        worker c \n" +
            "            on a.AUDITFLOW_id = c.AUDITFLOW_id \n" +
            "    left join\n" +
            "        dept d \n" +
            "            on c.dept_id = d.dept_id \n" +
            "\t\tleft join\n" +
            "\t\t\t\tstaff e\n" +
            "\t\t\t\t\ton a.staff_id = e.staff_id\n" +
            "\t\t\tleft join \n" +
            "\t\t\t\tstaff ee\n" +
            "\t\t\t\t\ton b.staff_id = ee.staff_id\n" +
            "    where\n" +
            "        a.AUDITFLOW_ID=#{id} \n" +
            "    ORDER BY\n" +
            "        b.AUDITFLOWDETAIL_ID")

    List<WorkerVo> findSelectById(@Param("id") Long id);
    //查询那个 步骤条的名称   废弃！！！！
    @Select("select\n" +
            "        a.AUDITFLOW_ID,\n" +
            "        e.staff_name as staff_name1,\n" +
            "        ee.staff_name as staff_name2,\n" +
            "        c.worker_date,\n" +
            "        a.auditflow_state,\n" +
            "        dept_name,\n" +
            "        c.WORKER_TYPE,\n" +
            "        c.WORKER_REMARKS,\n" +
            "        b.AUDITFLOWDETAI_STATE \n" +
            "    from\n" +
            "        AUDITFLOW a \n" +
            "    left join\n" +
            "        AUDITFLOWDETAIL b \n" +
            "            on a.AUDITFLOW_ID = b.AUDITFLOW_ID \n" +
            "    left join\n" +
            "        worker c \n" +
            "            on a.AUDITFLOW_id = c.AUDITFLOW_id \n" +
            "    left join\n" +
            "        dept d \n" +
            "            on c.dept_id = d.dept_id \n" +
            "\t\tleft join\n" +
            "\t\t\t\tstaff e\n" +
            "\t\t\t\t\ton a.staff_id = e.staff_id\n" +
            "\t\t\tleft join \n" +
            "\t\t\t\tstaff ee\n" +
            "\t\t\t\t\ton b.staff_id = ee.staff_id\n" +
            "    where\n" +
            "        a.AUDITFLOW_ID=#{id} \n" +
            "    ORDER BY\n" +
            "        d.CREATED_TIME")
    List<WorkerVo> findSelectByIdName(@Param("id") Long id);

    //按名称搜索
    @Select("select\n" +
            "                ac.staff_name as staff_name1,\n" +
            "                a.auditflow_Title,\n" +
            "                b.AUDITFLOWDETAIL_id,\n" +
            "                a.AUDITFLOW_ID,\n" +
            "                bc.staff_name as staff_name2,\n" +
            "                a.AUDITFLOW_STATE,\n" +
            "                b.AUDITFLOWDETAI_STATE,\n" +
            "                b.created_time,\n" +
            "                b.UPDATED_TIME \n" +
            "            from\n" +
            "                AUDITFLOW a \n" +
            "            left join\n" +
            "                AUDITFLOWDETAIL b \n" +
            "                    on a.AUDITFLOW_ID = b.AUDITFLOW_ID  " +
            "\t\t\t\t\t\tleft join staff ac on a.STAFF_ID=ac.STAFF_ID " +
            "\t\t\t\t\t\tleft join staff bc on b.STAFF_ID=bc.STAFF_ID " +
            "${ew.customSqlSegment}")
    IPage<WorkerVo> findSelectPageWorker(Page<WorkerVo> page, @Param(Constants.WRAPPER) QueryWrapper<WorkerVo> wrapper);

    //根据id查询 我的申请
    @Select("SELECT  a.AUDITFLOW_ID,\n" +
            "\t\t\t\tA.AUDITFLOW_TITLE,\n" +
            "        AA.staff_name as staff_name1,\n" +
            "        BB.staff_name as staff_name2,\n" +
            "        a.auditflow_state, \t\t\n" +
            "        b.AUDITFLOWDETAI_STATE,\n" +
            "\t\t\t\ta.CREATED_TIME,\n" +
            "\t\t\t\ta.UPDATED_TIME\n" +
            "FROM\n" +
            "AUDITFLOW A\n" +
            "LEFT JOIN\n" +
            "AUDITFLOWDETAIL B\n" +
            "ON A.AUDITFLOW_ID = B.AUDITFLOW_ID\n" +
            "LEFT JOIN\n" +
            "STAFF AA\n" +
            "ON AA.STAFF_ID = A.STAFF_ID\n" +
            "LEFT JOIN\n" +
            "STAFF BB\n" +
            "ON BB.STAFF_ID = B.STAFF_ID\n" +
            "WHERE AA.STAFF_ID = #{id}\n")
    IPage<WorkerVo> findeByIdUser1(Page<WorkerVo> page,@Param("id") Long id);

}
