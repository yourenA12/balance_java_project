package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.FixedVo;

import java.util.List;

public interface FixedVoService extends IService<FixedVo> {
    List<FixedVo> findSelectByIdFix(Long id);
}
