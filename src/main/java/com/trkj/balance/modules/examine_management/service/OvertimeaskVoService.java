package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.OvertimeaskVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OvertimeaskVoService extends IService<OvertimeaskVo> {
    List<OvertimeaskVo> findSelectByIdOvertimeask(Long id);

}
