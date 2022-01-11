package com.trkj.balance.modules.employee_management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 录用表
 * </p>
 *
 * @author 林落。
 * @since 2022-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EMPLOYMENT_TABLE")
@ApiModel(value="EmploymentTable对象", description="录用表")
public class EmploymentTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId("EMPLOYMENT_ID")
    private Long employmentId;

    @ApiModelProperty(value = "简历编号")
    @TableField("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "备注")
    @TableField("REMARKS")
    private String remarks;

    @ApiModelProperty(value = "入职时间")
    @TableField("HIREDATE")
    private Date hiredate;

    @ApiModelProperty(value = "试用期")
    @TableField("PROBATION")
    private String probation;

    @ApiModelProperty(value = "试用期月薪")
    @TableField("PROBATIONARY")
    private Long probationary;

    @TableField("POSITIVE_MONTHLY")
    private Long positiveMonthly;

    @ApiModelProperty(value = "放弃原因")
    @TableField("WAIVE_REASON")
    private String waiveReason;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
