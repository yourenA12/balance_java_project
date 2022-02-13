package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryVoMapper extends BaseMapper<Archive> {
}
