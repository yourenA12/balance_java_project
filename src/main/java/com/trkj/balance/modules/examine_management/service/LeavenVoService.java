package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.LeaveVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeavenVoService extends IService<LeaveVo> {
    List<LeaveVo> findeSeelectById(@Param("id") Long id);
}
