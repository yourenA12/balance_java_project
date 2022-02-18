package com.trkj.balance.modules.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.employee_management.vo.EntryhirdeVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;

public interface EntryhirdeVoService extends IService<EntryhirdeVo> {

    //多表查询待入职信息
    IPage<EntryhirdeVo> selectEntryhirde1(Page<EntryhirdeVo> page, String staffNameSearch, ArrayList deptIds, String postSearch, Date clockTimeStart, Date clockTimeEnd);

    //查询放弃入职员工
    IPage<EntryhirdeVo> selectEntryhirdeFQ(Page<EntryhirdeVo> page,String staffNameSearch, ArrayList deptIds,String postSearch);

    //查询本月新入职员工
    int selectFqhirdate(@Param("date") String date);


}
