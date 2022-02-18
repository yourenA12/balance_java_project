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

}
