package com.trkj.balance.modules.system_managementTest.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.ArrayList;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
 * @since 2022-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DEPT")
@ApiModel(value="Deptp对象", description="")
public class Deptp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("DEPT_ID")
    private Long deptId;

    @TableField("SUPERIOR_DEPT_ID")
    private Long deptPid;

    @TableField("DEPT_STATE")
    private Long deptState;

    @TableField("DEPT_NAME")
    private String deptName;

    @TableField("STAFF_ID")
    private Long staffId;

    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @TableField("REVISION")
    private Long revision;

    @TableField("IS_DELETED")
    private Long isDeleted;

    @TableField(exist = false)
    private List<Deptp> children =new ArrayList<>();


}
