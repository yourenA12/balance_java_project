package com.trkj.balance.modules.recruitment_management.entity;

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
 * 工作经历表
 * </p>
 *
 * @author 米西米西
 * @since 2022-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WORK_EXPERIENCESS")
@KeySequence(value = "WORK_EXPERIENCESS_ID",clazz = Long.class)
@ApiModel(value="WorkExperiencess对象", description="工作经历表")
public class WorkExperiencess implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("WORK_EXPERIENCESS_ID")
    private Long workExperiencessId;

    @ApiModelProperty(value = "开始时间")
    @TableField("WORK_STARE_TIME")
    private Date workStareTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("WORK_END_TIME")
    private Date workEndTime;

    @ApiModelProperty(value = "简历编号外键")
    @TableField("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "公司名称")
    @TableField("COMPANY_NAME")
    private String companyName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "所属行业")
    @TableField("POSITION_INDUSTRY")
    private String positionIndustry;

    @ApiModelProperty(value = "工作描述")
    @TableField("POSITION_DESCRIBE")
    private String positionDescribe;

    @ApiModelProperty(value = "税前月薪")
    @TableField("POSITION_SQMONTHLY")
    private Long positionSqmonthly;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
