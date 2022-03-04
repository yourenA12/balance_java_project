package com.trkj.balance.modules.examine_management.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuitnVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "离职编号")
    @TableId("QUIT_ID")
    private Long quitId;

    @ApiModelProperty(value = "审批编号")
    @TableField("AUDITFLOW_ID")
    private Long auditflowId;

    @ApiModelProperty(value = "员工编号")
    @TableField("STAFF_ID")
    private Long staffId;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName1;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "离职类型")
    @TableField("QUIT_TYPE")
    private String quitType;

    @ApiModelProperty(value = "离职说明")
    @TableField("QUIT_EXPLAIN")
    private String quitExplain;

    @ApiModelProperty(value = "员工名称")
    @TableField("STAFF_NAME")
    private String staffName2;


    @ApiModelProperty(value = "状态 0:不同意 1:同意")
    @TableField("QUIT_STATE")
    private Long quitState;

    @ApiModelProperty(value = "申请离职日期")
    @TableField("APPLY_QUIT_DATE")
    private Date applyQuitDate;

    @ApiModelProperty(value = "正式离职日期")
    @TableField("FORMAL_QUIT_DATE")
    private Date formalQuitDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "审核状态")
    @TableField("AUDITFLOWDETAI_STATE")
    private Long auditflowdetaiState;

}
