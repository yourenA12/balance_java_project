package com.trkj.balance.modules.salary_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.WorkExperience;
import com.trkj.balance.modules.salary_management.entity.Workscheme;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 加班方案表 服务类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-12
 */
public interface WorkschemeService extends IService<Workscheme> {

    //新增加班方案
    int insertWorkscheme(Workscheme workscheme);

    //查询加班方案
    IPage<Workscheme> selectWorkscheme(Page<Workscheme> page);

    //修改加班方案状态
    int updateWorkschemeState(Workscheme workscheme);

    //删除加班方案
    int deleteWorkscheme(Long id);

    //根据id查询加班方案信息
    Workscheme selectWorkschemeId(Long id );

    //修改加班方案
    int updateWorkscheme(Workscheme workscheme);
}
