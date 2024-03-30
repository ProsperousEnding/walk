package com.code.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 网址表
 *
 * @TableName web_website
 */
@TableName(value = "web_website")
@Data
public class Website implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 网站url
     */
    @TableField(value = "url")
    private String url;

    /**
     * 网址标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 网址描述
     */
    @TableField(value = "web_describe")
    private String webDescribe;

    /**
     * 网址点击量
     */
    @TableField(value = "click")
    private String click;

    /**
     * 网址封面
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 网址分类id
     */
    @TableField(value = "category_type")
    private Long categoryType;

    /**
     * 收录时间
     */
    @TableField(value = "inclusion_time")
    private Date inclusionTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 删除标识（0正常，1已删除）
     */
    @TableField(value = "del_tag")
    private Integer delTag;

    /**
     * 创建人
     */
    @TableField(value = "created_by")
    private Long createdBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}