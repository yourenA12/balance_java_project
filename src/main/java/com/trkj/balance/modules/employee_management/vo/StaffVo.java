package com.trkj.balance.modules.employee_management.vo;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author 友人A
 * @since 2021-12-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@KeySequence(value = "STAFF_ID",clazz = Long.class)

public class StaffVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "获奖人编号")
    @TableId("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工姓名")
    @TableField("STAFF_NAME")
    private String staffName;

    @ApiModelProperty(value = "性别")
    @TableField("STAFF_SEX")
    private String staffSex;

    @ApiModelProperty(value = "手机号码")
    @TableField("STAFF_PHONE")
    private Long staffPhone;

    @ApiModelProperty(value = "邮箱")
    @TableField("STAFF_EMAIL")
    private String staffEmail;

    @ApiModelProperty(value = "照片")
    @TableField("STAFF_PICTURE")
    private String staffPicture;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期")
    @TableField("STAFF_BIRTHDAY")
    private Date staffBirthday;

    @ApiModelProperty(value = "政治面貌")
    @TableField("STAFF_OUTLOOK")
    private String staffOutlook;

    @ApiModelProperty(value = "学历")
    @TableField("STAFF_EDUCATION")
    private String staffEducation;

    @ApiModelProperty(value = "职位编号")
    @TableId("POSITION_ID")
    private Long positionId;

    @ApiModelProperty(value = "密码")
    @TableField("STAFF_PASS")
    private String staffPass;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "入职日期")
    @TableField("STAFF_HIREDATE")
    private Date staffHiredate;

    @ApiModelProperty(value = "工龄 显示：xx年xx月xx日")
    @TableField("STAFF_WORKING_YEARS")
    private String staffWorkingYears;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "转正日期")
    @TableField("WORKER_DATE")
    private Date workerDate;


    @ApiModelProperty(value = "转正编号")
    @TableField("WORKER_ID")
    private Long workerId;

    @ApiModelProperty(value = "身份证")
    @TableField("STAFF_IDENTITY")
    private String staffIdentity;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

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

    @ApiModelProperty(value = "年龄")
    @TableField("STAFF_AGE")
    private String staffAge;

    @ApiModelProperty(value = "星座")
    @TableField("STAFF_SIGN")
    private String staffSign;

    @ApiModelProperty(value = "婚姻状态")
    @TableField("STAFF_MARITAL")
    private String staffMarital;

    @ApiModelProperty(value = "户口所在地")
    @TableField("STAFF_REGISTERED")
    private String staffRegistered;

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

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "编号")
    @TableId("WORK_EXPERIENCE_ID")
    private Long workExperienceId;

    @ApiModelProperty(value = "开始时间")
    @TableField("WORK_STARE_TIME")
    private Date workStareTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("WORK_END_TIME")
    private Date workEndTime;

    @ApiModelProperty(value = "公司名称")
    @TableField("COMPANY_NAME")
    private String companyName;

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
    @TableId("EDUCATION_ID")
    private Long educationId;

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

    @ApiModelProperty(value = "离职原因")
    @TableField("QUIT_EXPLAIN")
    private String quitExplain;

    @ApiModelProperty(value = "正式离职日期")
    @TableField("FORMAL_QUIT_DATE")
    private Date formalQuitDate;

}
