package com.trkj.balance.modules.employee_management.entity;

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
 * 受教育经历表
 * </p>
 *
 * @author 林落。
 * @since 2021-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EDUCATION")
@KeySequence(value = "EDUCATION_ID",clazz = Long.class)
@ApiModel(value="Education对象", description="受教育经历表")
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("EDUCATION_ID")
    private Long educationId;

    @ApiModelProperty(value = "开始时间")
    @TableField("EDUCATION_START_TIME")
    private Date educationStartTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("EDUCATION_END_TIME")
    private Date educationEndTime;

    @ApiModelProperty(value = "员工编号外键")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "学校名称")
    @TableField("EDUCATION_STUDENTNAME")
    private String educationStudentname;

    @ApiModelProperty(value = "所属专业")
    @TableField("EDUCATION_MAJOR")
    private String educationMajor;

    @ApiModelProperty(value = "是否全日制")
    @TableField("EDUCATION_FULL_TIME")
    private Long educationFullTime;

    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @TableField("IS_DELETED")
    private Long isDeleted;


}
