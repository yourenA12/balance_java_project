package com.trkj.balance.modules.examine_management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.examine_management.vo.WorkerVo;
import com.trkj.balance.modules.system_management.entity.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface NoticeVoMapper extends BaseMapper<NoticeVo> {
    @Select("select N.*,\n" +
            "S.NOTICE_STAFF_ID,S.NOTICE_STATE as noticeState1,\n" +
            "S.STAFF_ID as staffId1 \n" +
            "from NOTICE N \n" +
            "LEFT JOIN NOTICE_STAFF S \n" +
            "on N.NOTICE_ID = S.NOTICE_ID ${ew.customSqlSegment}")
    IPage<NoticeVo> findNoticeVo(Page<NoticeVo> page, @Param(Constants.WRAPPER) QueryWrapper<NoticeVo> wrapper);

    //根据id查询公告详情
    @Select("SELECT A.NOTICE_ID,B.NOTICE_TITLE,A.STAFF_ID,C.STAFF_NAME,b.NOTICE_MATTER,A.NOTICE_STATE FROM NOTICE_STAFF A\n" +
            "LEFT JOIN NOTICE B ON A.NOTICE_ID = B.NOTICE_ID\n" +
            "LEFT JOIN STAFF C ON C.STAFF_ID =\tB.STAFF_ID\n" +
            "WHERE A.STAFF_ID = #{id} and A.NOTICE_STATE = 0")
    List<NoticeVo> findSelectByIdNotice(@Param("id")Long id);
    //根据id查询公告详情 已读详情
    @Select("SELECT A.NOTICE_ID,B.NOTICE_TITLE,A.STAFF_ID,C.STAFF_NAME,b.NOTICE_MATTER,A.NOTICE_STATE FROM NOTICE_STAFF A\n" +
            "LEFT JOIN NOTICE B ON A.NOTICE_ID = B.NOTICE_ID\n" +
            "LEFT JOIN STAFF C ON C.STAFF_ID =\tB.STAFF_ID\n" +
            "WHERE A.STAFF_ID = #{id} and A.NOTICE_STATE = 1")
    List<NoticeVo> findSelectByIdNotice1(@Param("id")Long id);

}
