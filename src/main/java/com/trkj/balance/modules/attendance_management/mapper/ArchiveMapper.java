package com.trkj.balance.modules.attendance_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.entity.Archive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 月报表归档表 Mapper 接口
 * </p>
 *
 * @author 晚风
 * @since 2022-02-07
 */
@Mapper
public interface ArchiveMapper extends BaseMapper<Archive> {

    @Select("select * from ARCHIVE\n" +
            "where TO_CHAR(UPDATED_TIME,'yyyy-MM') = TO_CHAR(sysdate，'yyyy-MM')")
    IPage<Archive> selectArchive(Page<Archive>page);

}