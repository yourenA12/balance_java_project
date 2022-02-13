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
 * 加班方案表
 * </p>
 *
 * @author 林落。
 * @since 2022-02-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WORKSCHEME")
@KeySequence(value = "WORKSCHEME_ID",clazz = Long.class)
@ApiModel(value="Workscheme对象", description="加班方案表")
public class Workscheme implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "加班方案编号")
    @TableId("WORKSCHEME_ID")
    private Long workschemeId;

    @ApiModelProperty(value = "加班方案名称")
    @TableField("WORKSCHEME_NAME")
    private String workschemeName;

    @ApiModelProperty(value = "节假日加班比例")
    @TableField("WORKSCHEME_HOLIDAYRATIO")
    private Long workschemeHolidayratio;

    @ApiModelProperty(value = "休息日加班比例")
    @TableField("WORKSCHEME_DAYOFFRATIO")
    private Long workschemeDayoffratio;

    @ApiModelProperty(value = "工作日加班比例")
    @TableField("WORKSCHEME_WORKRATIO")
    private Long workschemeWorkratio;

    @ApiModelProperty(value = "状态;0：启用，1：禁用")
    @TableField("WORKSCHEME_STATE")
    private Long workschemeState;

    @ApiModelProperty(value = "备注")
    @TableField("WORKSCHEME_REMARK")
    private String workschemeRemark;

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
