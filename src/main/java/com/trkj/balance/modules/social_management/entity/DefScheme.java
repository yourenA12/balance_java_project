package com.trkj.balance.modules.social_management.entity;

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
 * 默认方案表
 * </p>
 *
 * @author 友人A
 * @since 2022-02-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEF_SCHEME")
@ApiModel(value="DefScheme对象", description="默认方案表")
public class DefScheme implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "默认方案表编号")
    @TableId("DEF_SCHEME_ID")
    private Long defSchemeId;

    @ApiModelProperty(value = "默认参保方案编号")
    @TableField("DEF_INSURED_ID")
    private Long defInsuredId;

    @ApiModelProperty(value = "最少基数")
    @TableField("DEF_SCHEME_MIN")
    private Long defSchemeMin;

    @ApiModelProperty(value = "最多基数")
    @TableField("DEF_SCHEME_MAX")
    private Long defSchemeMax;

    @ApiModelProperty(value = "基数上限")
    @TableField("DEF_SCHEME_UPPER")
    private Long defSchemeUpper;

    @ApiModelProperty(value = "基数下限")
    @TableField("DEF_SCHEME_FLOOR")
    private Long defSchemeFloor;

    @ApiModelProperty(value = "个人缴纳比例")
    @TableField("DEF_SCHEME_PERSON_PROP")
    private Double defSchemePersonProp;

    @ApiModelProperty(value = "个人固定缴纳")
    @TableField("DEF_SCHEME_PERSON_SUM")
    private Double defSchemePersonSum;

    @ApiModelProperty(value = "企业缴纳比例")
    @TableField("DEF_SCHEME_FIRM_PROP")
    private Double defSchemeFirmProp;

    @ApiModelProperty(value = "企业缴纳比例")
    @TableField("DEF_SCHEME_FIRM_SUM")
    private Double defSchemeFirmSum;

    @ApiModelProperty(value = "参保类型")
    @TableField("DEF_SCHEME_TYPE")
    private String defSchemeType;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
