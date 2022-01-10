package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.entity.Worker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 转正 Mapper 接口
 * </p>
 *
 * @author jiejie
 * @since 2022-01-04
 */
@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {

}
