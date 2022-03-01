package com.trkj.balance.modules.social_management.entity;

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
 * 
 * </p>
 *
 * @author 友人A
 * @since 2022-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("INSURED_DETAIL_SON")
@KeySequence(value = "INSURED_DETAIL_SON_ID",clazz = Long.class)
@ApiModel(value="InsuredDetailSon对象", description="")
public class InsuredDetailSon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("INSURED_DETAIL_SON_ID")
    private Long insuredDetailSonId;

    @TableField("STAFF_ID")
    private Long staffId;

    @TableField("INSURED_PAYMENT_TYPE")
    private String insuredPaymentType;

    @TableField("INSURED_PAYMENT_NUMBER")
    private Double insuredPaymentNumber;

    @TableField("INS_ARCHIVE_PERSON_PROP")
    private Double insArchivePersonProp;

    @TableField("INS_ARCHIVE_PERSON_MONEY")
    private Double insArchivePersonMoney;

    @TableField("INS_ARCHIVE_PERSON_SUM")
    private Double insArchivePersonSum;

    @TableField("INS_ARCHIVE_FIRM_PROP")
    private Double insArchiveFirmProp;

    @TableField("INS_ARCHIVE_FIRM_MONEY")
    private Double insArchiveFirmMoney;

    @TableField("INS_ARCHIVE_FIRM_SUM")
    private Double insArchiveFirmSum;

    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @TableField("REVISION")
    private Long revision;

    @TableField("IS_DELETED")
    private Long isDeleted;


}
