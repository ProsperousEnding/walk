package com.code.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 网页_网页分类关联表
 *
 * @TableName web_web_cate
 */
@TableName(value = "web_web_cate")
@Getter
@Setter
public class WebCate implements Serializable {

    @TableId(value = "id")
    private Long id;

    /**
     * 网址id
     */
    @TableField(value = "web_id")
    private Long webId;

    /**
     * 网页类别id
     */
    @TableField(value = "cate_id")
    private Long cateId;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
