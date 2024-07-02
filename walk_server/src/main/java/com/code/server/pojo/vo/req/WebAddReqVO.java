package com.code.server.pojo.vo.req;

import lombok.Getter;

import java.util.List;

/**
 * 网址添加请求
 */
@Getter
public class WebAddReqVO {

    /**
     * 网站url
     */
    private String url;

    /**
     * 网址标题
     */
    private String title;

    /**
     * 网址描述
     */
    private String webDescribe;

    /**
     * 网址封面
     */
    private String cover;

    /**
     * 网址图标
     */
    private String ico;

    /**
     * 网页类型集合
     */
    private List<Long> categoryIds;

}
