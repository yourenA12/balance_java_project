package com.trkj.balance.modules.social_management.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsuredMonthVo {

    @TableField(exist = false)
    private String insuredMonth; // 参保月份

    @TableField(exist = false)
    private int insuredNumber; // 参保人数

    @TableField(exist = false)
    private double  Individual; // 个人缴纳

    @TableField(exist = false)
    private double companies ; // 企业缴纳








}
