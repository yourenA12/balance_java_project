package com.trkj.balance.modules.employee_management.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntryhirdeVo  implements Serializable {

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

    @ApiModelProperty(value = "邮箱")
    @TableField("RESUME_MAILBOX")
    private String resumeMailbox;

    @ApiModelProperty(value = "照片")
    @TableField("RESUME_PHOTO")
    private String resumePhoto;

    @ApiModelProperty(value = "介绍")
    @TableField("RESUME_INTRODUCE")
    private String resumeIntroduce;

    @ApiModelProperty(value = "出生日期")
    @TableField("RESUME_BIRTHDAY")
    private Date resumeBirthday;

    @ApiModelProperty(value = "户口所在地")
    @TableField("RESUME_RESIDENCE")
    private String resumeResidence;

    @ApiModelProperty(value = "招聘计划编号")
    @TableField("RECRUITMENT_PLAN_ID")
    private Long recruitmentPlanId;

    @ApiModelProperty(value = "政治面貌")
    @TableField("RESUME_POLITICAL_OUTLOOK")
    private String resumePoliticalOutlook;


    @ApiModelProperty(value = "编号")
    @TableId("EMPLOYMENT_ID")
    private Long employmentId;


    @ApiModelProperty(value = "备注")
    @TableField("REMARKS")
    private String remarks;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "入职时间")
    @TableField("HIREDATE")
    private Date hiredate;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;


    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;


    @ApiModelProperty(value = "部门职位编号")
    @TableId("DEPT_POST_ID")
    private Long deptPostId;


    @ApiModelProperty(value = "职位名称")
    @TableField("POST_NAME")
    private String postName;



    @ApiModelProperty(value = "密码")
    @TableField("STAFF_PASS")
    private String staffPass;



    @ApiModelProperty(value = "转正编号")
    @TableField("WORKER_ID")
    private Long workerId;

    @ApiModelProperty(value = "身份证")
    @TableField("STAFF_IDENTITY")
    private String staffIdentity;


    @ApiModelProperty(value = "专业")
    @TableField("STAFF_MAJOR")
    private String staffMajor;

    @ApiModelProperty(value = "紧急联系人")
    @TableField("STAFF_EMERGENCY")
    private Long staffEmergency;

    @ApiModelProperty(value = "微信")
    @TableField("STAFF_WECHAT")
    private String staffWechat;

    @TableField("STAFF_QQ")
    private String staffQq;

    @ApiModelProperty(value = "银行卡号")
    @TableField("STAFF_CREDIT")
    private String staffCredit;

    @ApiModelProperty(value = "血型")
    @TableField("STAFF_BLOOD")
    private String staffBlood;

    @ApiModelProperty(value = "星座")
    @TableField("STAFF_SIGN")
    private String staffSign;

    @ApiModelProperty(value = "婚姻状态")
    @TableField("STAFF_MARITAL")
    private String staffMarital;


    @ApiModelProperty(value = "毕业学校")
    @TableField("STAFF_SCHOOL")
    private String staffSchool;

    @ApiModelProperty(value = "现住地址")
    @TableField("STAFF_ADDRESS")
    private String staffAddress;

    @ApiModelProperty(value = "员工状态")
    @TableField("STAFF_STATE")
    private Long staffState;


    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @TableLogic // 逻辑删除注解
    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @Version // 乐观锁注解
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;


    @ApiModelProperty(value = "编号")
    @TableId("WORK_EXPERIENCESS_ID")
    private Long workExperiencessId;

    @ApiModelProperty(value = "开始时间")
    @TableField("WORK_STARE_TIME")
    private Date workStareTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("WORK_END_TIME")
    private Date workEndTime;

    @ApiModelProperty(value = "公司名称")
    @TableField("COMPANY_NAME")
    private String companyName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "所属行业")
    @TableField("POSITION_INDUSTRY")
    private String positionIndustry;

    @ApiModelProperty(value = "工作描述")
    @TableField("POSITION_DESCRIBE")
    private String positionDescribe;

    @ApiModelProperty(value = "税前月薪")
    @TableField("POSITION_SQMONTHLY")
    private Long positionSqmonthly;

    @ApiModelProperty(value = "编号")
    @TableId("EDUCATIONSS_ID")
    private Long educationssId;

    @ApiModelProperty(value = "开始时间")
    @TableField("EDUCATION_START_TIME")
    private Date educationStartTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("EDUCATION_END_TIME")
    private Date educationEndTime;

    @ApiModelProperty(value = "学校名称")
    @TableField("EDUCATION_STUDENTNAME")
    private String educationStudentname;

    @ApiModelProperty(value = "所属专业")
    @TableField("EDUCATION_MAJOR")
    private String educationMajor;

    @ApiModelProperty(value = "是否全日制")
    @TableField("EDUCATION_FULL_TIME")
    private Long educationFullTime;


    @ApiModelProperty(value = "毕业学校")
    @TableField("RESUME_SCOLLER")
    private String resumeScoller;

    @ApiModelProperty(value = "婚姻状况：已婚、未婚、离婚")
    @TableField("RESUME_HY")
    private String resumeHy;


    @ApiModelProperty(value = "状态  0:新简历  1、候选人 2：已邀约  3:已淘汰 4:面试中 5:面试通过 6:复试中 7:待接受 8:已接受 9：已入职 10:已拒绝 11：放弃入职 12：已离职")
    @TableField("RESUME_ZT")
    private String resumeZt;


        @ApiModelProperty(value = "试用期")
        @TableField("PROBATION")
        private String probation;

        @ApiModelProperty(value = "试用期月薪")
        @TableField("PROBATIONARY")
        private Long probationary;

    @ApiModelProperty(value = "正式月薪")
        @TableField("POSITIVE_MONTHLY")
        private Long positiveMonthly;

        @ApiModelProperty(value = "放弃原因")
        @TableField("WAIVE_REASON")
        private String waiveReason;




    }



