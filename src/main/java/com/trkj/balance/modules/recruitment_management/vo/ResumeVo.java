package com.trkj.balance.modules.recruitment_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeVo implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "编号")
    @TableId("RESUME_ID")
    private Long resumeId;

    @ApiModelProperty(value = "名字")
    @TableField("RESUME_NAME")
    private String resumeName;

    @ApiModelProperty(value = "性别")
    @TableField("RESUME_SEX")
    private String resumeSex;

    @ApiModelProperty(value = "手机号码")
    @TableField("RESUME_PHONE")
    private Long resumePhone;

    @ApiModelProperty(value = "学历名称")
    @TableField("RESUME_EDUCATION")
    private String resumeEducation;

    @ApiModelProperty(value = "毕业学校")
    @TableField("RESUME_SCOLLER")
    private String resumeScoller;

    @ApiModelProperty(value = "婚姻状况：已婚、未婚、离婚")
    @TableField("RESUME_HY")
    private String resumeHy;

    @ApiModelProperty(value = "年龄")
    @TableField("RESUME_AGE")
    private Long resumeAge;

    @ApiModelProperty(value = "期望薪资")
    @TableField("RESUME_QXINGZ")
    private String resumeQxingz;

    @ApiModelProperty(value = "期望职位")
    @TableField("RESUME_QZHIW")
    private String resumeQzhiw;

    @ApiModelProperty(value = "身高")
    @TableField("RESUME_SHENGG")
    private String resumeShengg;

    @ApiModelProperty(value = "最近职位")
    @TableField("RESUME_ZJZW")
    private String resumeZjzw;

    @ApiModelProperty(value = "邮箱")
    @TableField("RESUME_MAILBOX")
    private String resumeMailbox;

    @ApiModelProperty(value = "照片")
    @TableField("RESUME_PHOTO")
    private String resumePhoto;

    @ApiModelProperty(value = "自我评价")
    @TableField("RESUME_INTRODUCE")
    private String resumeIntroduce;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    @TableField("RESUME_BIRTHDAY")
    private Date resumeBirthday;

    @ApiModelProperty(value = "户口所在地")
    @TableField("RESUME_RESIDENCE")
    private String resumeResidence;

    @TableField("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @TableField("RESUME_POLITICAL_OUTLOOK")
    private String resumePoliticalOutlook;

    @ApiModelProperty(value = "状态  0:新简历  1、候选人 2：已邀约  3:已淘汰 4:面试中 5:面试通过 6:复试中 7:待接受 8:已接受 9：已入职 10:已拒绝 11：放弃入职 12：已离职")
    @TableField("RESUME_ZT")
    private String resumeZt;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "投简时间")
    @TableField("TOUJ_TIME")
    private Date toujTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除;1表示删除，0 表示未删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;

    @ApiModelProperty(value = "所属专业")
    @TableField("EDUCATION_MAJOR")
    private String educationMajor;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "所属行业")
    @TableField("POSITION_INDUSTRY")
    private String positionIndustry;

    @ApiModelProperty(value = "公司名称")
    @TableField("COMPANY_NAME")
    private String companyName;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间")
    @TableField("WORK_STARE_TIME")
    private Date workStareTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    @TableField("WORK_END_TIME")
    private Date workEndTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间")
    @TableField("EDUCATION_START_TIME")
    private Date educationStartTime;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    @TableField("EDUCATION_END_TIME")
    private Date educationEndTime;



;



    @ApiModelProperty(value = "是否全日制")
    @TableField("EDUCATION_FULL_TIME")
    private Long educationFullTime;


}
