package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;

public interface WagenotfiledVoService extends IService<WagenotfiledVo> {

    //查询工资未未归档
    IPage<WagenotfiledVo> selectWagenotfiledVoPage(IPage<WagenotfiledVo> page,String seek);

    //查询工资归档
    IPage<WagenotfiledVo> selectWagenotfiledVosPage(IPage<WagenotfiledVo> page,String seek);
}
