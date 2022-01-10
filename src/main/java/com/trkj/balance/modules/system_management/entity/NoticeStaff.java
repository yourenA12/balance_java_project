package com.trkj.balance.modules.system_management.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公告员工表
 * </p>
 *
 * @author 友人A
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NOTICE_STAFF")
//value=自增序列名 calzz=实体类的数据类型
@KeySequence(value = "NOTICE_STAFF_ID",clazz = Long.class)
@ApiModel(value="NoticeStaff对象", description="公告员工表")
public class NoticeStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告员工编号")
    @TableId("NOTICE_STAFF_ID")
    private Long noticeStaffId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "公告编号")
    @TableField("NOTICE_ID")
    private Long noticeId;

    @ApiModelProperty(value = "公告状态")
    @TableField("NOTICE_STATE")
    private Long noticeState;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
