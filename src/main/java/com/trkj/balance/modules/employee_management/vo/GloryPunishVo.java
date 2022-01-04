package com.trkj.balance.modules.employee_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GloryPunishVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "惩罚编号")
    @TableId("PUNISH_ID")
    private Long punishId;

    @ApiModelProperty(value = "惩罚类型")
    @TableField("PUNISH_TYPE")
    private String punishType;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "惩罚原因")
    @TableField("PUNISH_CAUSE")
    private String punishCause;

    @ApiModelProperty(value = "惩罚单位")
    @TableField("PUNISH_UNIT")
    private String punishUnit;

    @ApiModelProperty(value = "是否撤销")
    @TableField("IS_REVOCATION")
    private Long isRevocation;

    @ApiModelProperty(value = "备注")
    @TableField("PUNISH_REMARK")
    private String punishRemark;

    @ApiModelProperty(value = "荣誉/奖励编号")
    @TableId("GLORY_ID")
    private Long gloryId;

    @ApiModelProperty(value = "荣誉/奖励名称")
    @TableField("GLORY_NAME")
    private String gloryName;


    @ApiModelProperty(value = "颁发单位名称")
    @TableField("GLORY_UNITNAME")
    private String gloryUnitname;

    @ApiModelProperty(value = "备注")
    @TableField("GLORY_REMARK")
    private String gloryRemark;

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
