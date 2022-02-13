package com.trkj.balance.modules.attendance_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.balance.modules.attendance_management.entity.Classes;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 月报表归档表 服务类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-07
 */
public interface ArchiveService extends IService<Archive> {

    //查询
     public IPage<Archive> selectArchive(Page<Archive>page);

     //模糊搜索
     IPage<Archive> moss(int page, int size, String staffName);

}
