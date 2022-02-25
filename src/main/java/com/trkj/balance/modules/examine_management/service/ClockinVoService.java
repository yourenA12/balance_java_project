package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.vo.ClockinVo;

public interface ClockinVoService extends IService<ClockinVo> {

    //查询
     ClockinVo daka(Long id);

}
