package com.trkj.balance.modules.system_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author 友人A
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NOTICE")
//value=自增序列名 calzz=实体类的数据类型
@KeySequence(value = "NOTICE_ID",clazz = Long.class)
@ApiModel(value="Notice对象", description="公告表")
public class NoticeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告编号")
    @TableId("NOTICE_ID")
    private Long noticeId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId1;


    @ApiModelProperty(value = "公告类型 0:要事性 1:政策性 2:任免性")
    @TableField("NOTICE_TYPE")
    private Long noticeType;

    @ApiModelProperty(value = "公告标题")
    @TableField("NOTICE_TITLE")
    private String noticeTitle;

    @ApiModelProperty(value = "公告状态 0:启用 1:禁用")
    @TableField("NOTICE_STATE")
    private Long noticeState;

    @ApiModelProperty(value = "公告状态 0:启用 1:禁用")
    @TableField("NOTICE_STATE")
    private Long noticeState1;

    @ApiModelProperty(value = "发布人")
    @TableField("NOTICE_PEOPLE")
    private String noticePeople;

    @ApiModelProperty(value = "职位")
    @TableField("NOTICE_POST")
    private String noticePost;

    @ApiModelProperty(value = "发布内容")
    @TableField("NOTICE_MATTER")
    private String noticeMatter;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "公告员工编号")
    @TableId("NOTICE_STAFF_ID")
    private Long noticeStaffId;

}
