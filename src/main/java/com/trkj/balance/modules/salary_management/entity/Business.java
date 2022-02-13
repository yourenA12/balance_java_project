package com.trkj.balance.modules.salary_management.entity;

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
 * 出差方案表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("BUSINESS")
@KeySequence(value = "BUSINESS_ID",clazz = Long.class)
@ApiModel(value="Business对象", description="出差方案表")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出差方案编号")
    @TableId("BUSINESS_ID")
    private Long businessId;

    @ApiModelProperty(value = "出差方案名称")
    @TableField("BUSINESS_NAME")
    private String businessName;

    @ApiModelProperty(value = "出差一天金额")
    @TableField("BUSINESS_ONEMONEY")
    private Double businessOnemoney;

    @ApiModelProperty(value = "状态")
    @TableField("BUSINESS_STATE")
    private Long businessState;

    @ApiModelProperty(value = "备注")
    @TableField("BUSINESS_REMARK")
    private String businessRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version // 乐观锁注解
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
