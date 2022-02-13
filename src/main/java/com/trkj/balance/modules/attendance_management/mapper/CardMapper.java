package com.trkj.balance.modules.attendance_management.mapper;

import com.trkj.balance.modules.attendance_management.entity.Card;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 补打卡表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2022-02-05
 */
@Mapper
public interface CardMapper extends BaseMapper<Card> {

}
