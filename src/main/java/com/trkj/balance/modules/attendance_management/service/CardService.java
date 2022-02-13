package com.trkj.balance.modules.attendance_management.service;

import com.trkj.balance.modules.attendance_management.entity.Card;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 补打卡表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-05
 */
public interface CardService extends IService<Card> {
    //删除
    public int Carddelete(Long id);

}
