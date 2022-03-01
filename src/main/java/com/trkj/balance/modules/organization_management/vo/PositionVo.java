package com.trkj.balance.modules.organization_management.vo;


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
public class PositionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门职位中间表编号")
    @TableId("DEPT_POST_ID")
    private Long deptPostId;

    @ApiModelProperty(value = "部门编号")
    @TableId("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DEPT_NAME")
    private String deptName;

    @ApiModelProperty(value = "职位编号")
    @TableId("POSITION_ID")
    private Long positionId;

    @ApiModelProperty(value = "职位名称")
    @TableField("POSITION_NAME")
    private String positionName;

    @ApiModelProperty(value = "职位说明")
    @TableField("POSITION_DESCRIPTION")
    private String positionDescription;

    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @ApiModelProperty(value = "逻辑删除;0：未删除，1：已删除")
    @TableField("IS_DELETED")
    private Long isDeleted;

}
