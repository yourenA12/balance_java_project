package com.trkj.balance.modules.examine_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.examine_management.entity.ClockRecord;
import com.trkj.balance.modules.examine_management.vo.ClockinVo;

public interface ClockinssService extends IService<ClockRecord> {
    //添加
    int addclock(ClockRecord clockRecord);

    //修改
    int amendclock(ClockRecord clockRecord);

}
