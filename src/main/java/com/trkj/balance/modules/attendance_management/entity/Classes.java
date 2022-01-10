package com.trkj.balance.modules.attendance_management.entity;

import com.baomidou.mybatisplus.annotation.*;

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
 * 班次方案表
 * </p>
 *
 * @author 晚风
 * @since 2021-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CLASSES")
@KeySequence(value = "CLASSES_ID",clazz = Long.class) // id 自增
@ApiModel(value="Classes对象", description="班次方案表")
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班次编号")
    @TableId("CLASSES_ID")
    private Long classesId;

    @ApiModelProperty(value = "班次名称")
    @TableField("CLASSES_NAME")
    private String classesName;

//    @JsonFormat(pattern="HH:mm:ss")
    @ApiModelProperty(value = "上班时间")
    @TableField("CLASSES_BEGIN_DATE")
    private Date classesBeginDate;

//    @JsonFormat(pattern="HH:mm:ss")
    @ApiModelProperty(value = "下班时间")
    @TableField("CLASSES_END_DATE")
    private Date classesEndDate;

    @ApiModelProperty(value = "状态")
    @TableField("CLASSES_STATE")
    private Long classesState;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;


}
