package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "补打卡编号")
    @TableId("CARD_ID")
    private Long cardId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "审核人编号")
    @TableField("STAFF_ID")
    private Long staffId2;

    @ApiModelProperty(value = "审核人")
    @TableField("STAFF_NAME")
    private String staffName2;


    @ApiModelProperty(value = "补打卡类型")
    @TableField("CARD_TYPE")
    private String cardType;

    @ApiModelProperty(value = "补打卡时间")
    @TableField("CARD_DATE")
    private Date cardDate;

    @ApiModelProperty(value = "备注")
    @TableField("CARD_REMARKS")
    private String cardRemarks;

    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("CARD_STATE")
    private Long cardState;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

}
