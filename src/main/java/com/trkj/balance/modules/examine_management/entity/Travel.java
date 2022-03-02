package com.trkj.balance.modules.examine_management.entity;

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
 * 出差表
 * </p>
 *
 * @author jiejie
 * @since 2022-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRAVEL")
@KeySequence(value = "TRAVEL_ID",clazz = Long.class)
@ApiModel(value="Travel对象", description="出差表")
public class Travel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出差编号")
    @TableId("TRAVEL_ID")
    private Long travelId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "发起人部门")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "出差地点")
    @TableField("TRAVEL_PLACE")
    private String travelPlace;

    @ApiModelProperty(value = "出差事由")
    @TableField("TRAVEL_MATTER")
    private String travelMatter;

    @ApiModelProperty(value = "出差开始时间")
    @TableField("TRAVEL_S_DATE")
    private Date travelSDate;

    @ApiModelProperty(value = "出差结束时间")
    @TableField("TRAVEL_E_DATE")
    private Date travelEDate;

    @ApiModelProperty(value = "出差总时长")
    @TableField("TRAVEL_TOTAL_DATE")
    private Long travelTotalDate;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("TRAVEL_STATE")
    private Long travelState;

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
    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
