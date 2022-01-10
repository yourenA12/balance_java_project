package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 班次方案表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2021-12-30
 */
public interface ClassesService extends IService<Classes> {
    //分页
    public IPage<Classes> selsefy(Page<Classes> page);

    //新增
    int selsetj(Classes classes);

    //逻辑删除
    public int selsesc(Long id);

    //修改
    int amend(Classes classes);

    //模糊搜索
    IPage<Classes> dimsearch(int page,int size,String classesName);


}
