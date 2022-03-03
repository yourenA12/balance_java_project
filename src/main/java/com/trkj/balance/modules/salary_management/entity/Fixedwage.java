package com.trkj.balance.modules.salary_management.entity;

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
 * 固定工资表
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FIXEDWAGE")
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
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
