package com.trkj.balance.modules.examine_management.mapper;

import com.trkj.balance.modules.examine_management.entity.Auditflow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 审批主表 Mapper 接口
 * </p>
 *
 * @author jiejie
 * @since 2021-12-29
 */
@Mapper
public interface AuditflowMapper extends BaseMapper<Auditflow> {

}
