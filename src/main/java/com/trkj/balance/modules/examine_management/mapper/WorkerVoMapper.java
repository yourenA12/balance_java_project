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
    @Select("select  a.AUDITFLOW_ID,a.staff_name as staff_name1,b.staff_name as staff_name2,c.worker_date,a.auditflow_state,dept_name,c.WORKER_TYPE,c.WORKER_REMARKS,b.AUDITFLOWDETAI_STATE\n" +
            "from AUDITFLOW a\n" +
            "left join \n" +
            "AUDITFLOWDETAIL b\n" +
            "on a.AUDITFLOW_ID = b.AUDITFLOW_ID\n" +
            "left join\n" +
            "worker c \n" +
            "on a.AUDITFLOW_id = c.AUDITFLOW_id\n" +
            "left join\n" +
            "dept d\n" +
            "on c.dept_id = d.dept_id\n" +
            "where a.AUDITFLOW_ID=#{id} " +
            "ORDER BY d.CREATED_TIME")
    List<WorkerVo> findSelectById(@Param("id") Long id);


    //按名称搜索
    @Select("select  a.staff_name as staff_name1,a.auditflow_Title,b.AUDITFLOWDETAIL_id,a.AUDITFLOW_ID,b.staff_name as staff_name2,a.AUDITFLOW_STATE,b.AUDITFLOWDETAI_STATE,b.created_time,b.UPDATED_TIME  \n" +
            "from AUDITFLOW a\n" +
            "left join AUDITFLOWDETAIL b\n" +
            "on a.AUDITFLOW_ID = b.AUDITFLOW_ID " +
            "${ew.customSqlSegment}")
    IPage<WorkerVo> findSelectPageWorker(Page<WorkerVo> page, @Param(Constants.WRAPPER) QueryWrapper<WorkerVo> wrapper);

}
