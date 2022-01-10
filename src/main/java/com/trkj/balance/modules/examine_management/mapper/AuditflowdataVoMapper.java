package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.vo.AuditflowdataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/*
* 审批主表and审批明细表的mapper
* */
@Mapper
public interface AuditflowdataVoMapper extends BaseMapper<AuditflowdataVo> {
    //分页查询sql
   @Select("select a.CREATED_TIME,a.AUDITFLOW_ID,b.AUDITFLOWDETAIL_ID,a.AUDITFLOW_TYPE,a.STAFF_NAME as STAFF_NAME1,b.AUDITFLOWDETAI_STATE,b.STAFF_NAME as STAFF_NAME2,b.UPDATED_TIME,a.AUDITFLOW_TITLE from AUDITFLOW a LEFT OUTER join AUDITFLOWDETAIL b on a.AUDITFLOW_ID=b.AUDITFLOW_ID")
    IPage<AuditflowdataVo> findSelectPage(Page<AuditflowdataVo> page);
}
