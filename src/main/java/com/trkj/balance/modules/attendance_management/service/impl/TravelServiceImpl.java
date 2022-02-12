package com.trkj.balance.modules.attendance_management.service.impl;

import com.trkj.balance.modules.attendance_management.entity.Travel;
import com.trkj.balance.modules.attendance_management.mapper.TravelMapper;
import com.trkj.balance.modules.attendance_management.service.TravelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 出差表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-23
 */
@Service
public class TravelServiceImpl extends ServiceImpl<TravelMapper, Travel> implements TravelService {
    @Autowired
    public TravelMapper travelMapper;

    //删除
    @Override
    public int Traveldelete(Long id) {
        return travelMapper.deleteById(id);
    }
}
