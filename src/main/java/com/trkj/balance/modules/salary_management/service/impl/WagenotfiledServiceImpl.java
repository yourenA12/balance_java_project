package com.trkj.balance.modules.salary_management.service.impl;

import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;
import com.trkj.balance.modules.salary_management.mapper.WagenotfiledMapper;
import com.trkj.balance.modules.salary_management.service.WagenotfiledService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工资未归档表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-03-03
 */
@Service
public class WagenotfiledServiceImpl extends ServiceImpl<WagenotfiledMapper, Wagenotfiled> implements WagenotfiledService {
    @Autowired
    private WagenotfiledMapper wagenotfiledMapper;

    //修改工资状态为归档
    @Override
    public int updateWagenotfiledVo(Wagenotfiled wagenotfiled) {
        return wagenotfiledMapper.updateById(wagenotfiled);
    }
}
