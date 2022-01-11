package com.trkj.balance.modules.system_management.entity;

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
 * 公告部门表
 * </p>
 *
 * @author 友人A
 * @since 2022-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("NOTICE_DEPT")
//value=自增序列名 calzz=实体类的数据类型
@KeySequence(value = "NOTICE_DEPT_ID",clazz = Long.class)
@ApiModel(value="NoticeDept对象", description="公告部门表")
public class NoticeDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告部门编号")
    @TableId("NOTICE_DEPT_ID")
    private Long noticeDeptId;

    @ApiModelProperty(value = "部门编号")
    @TableField("DEPT_ID")
    private Long deptId;

    @ApiModelProperty(value = "公告编号")
    @TableField("NOTICE_ID")
    private Long noticeId;

    @ApiModelProperty(value = "创建时间 精确到秒")
    @TableField(value = "CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    @ApiModelProperty(value = "修改时间 精确到秒")
    @TableField(value = "UPDATED_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @Version
    @ApiModelProperty(value = "乐观锁")
    @TableField("REVISION")
    private Long revision;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 0:未删 1:已删 ")
    @TableField("IS_DELETED")
    private Long isDeleted;


}
