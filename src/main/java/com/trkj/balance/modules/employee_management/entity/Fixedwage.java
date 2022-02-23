package com.trkj.balance.modules.employee_management.entity;

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
 * 固定工资表
 * </p>
 *
 * @author 林落。
 * @since 2022-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FIXEDWAGE")
@KeySequence(value = "FIXEDWAGE_ID",clazz = Long.class)
@ApiModel(value="Fixedwage对象", description="固定工资表")
public class Fixedwage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "固定工资编号")
    @TableId("FIXEDWAGE_ID")
    private Long fixedwageId;

    @ApiModelProperty(value = "试用期基本工资")
    @TableField("FIXEDWAGE_PERIODMONEY")
    private Double fixedwagePeriodmoney;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "正式期基本工资")
    @TableField("FIXEDWAGE_OFFICIALMONEY")
    private Double fixedwageOfficialmoney;

    @ApiModelProperty(value = "备注")
    @TableField("FIXEDWAGE_REMARK")
    private String fixedwageRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @Version // 乐观锁注解
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;


    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "职位编号")
    @TableId("POSITION_ID")
    private Long positionId;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "入职日期")
    @TableField("STAFF_HIREDATE")
    private Date staffHiredate;

    @ApiModelProperty(value = "员工状态;0：在职，1：离职，2：实习，3：正式")
    @TableField("STAFF_STATE")
    private Long staffState;


}
