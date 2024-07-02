package com.code.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.code.server.entity.Website;
import com.code.server.pojo.vo.req.PageReqVO;
import com.code.server.pojo.vo.req.WebAddReqVO;

/**
 * @author ProsperousEnding
 * @description 针对表【web_website(网址表)】的数据库操作Service
 * @createDate 2024-03-30 23:51:55
 */
public interface WebsiteService extends IService<Website> {

    /**
     * 查询导航
     *
     * @param page 分页
     * @return Page<Website> 分页数据
     */
    Page<Website> queryNav(PageReqVO page);

    /**
     * 添加网址
     *
     * @param webAddReqVO 网址添加请求
     * @return Boolean 是否添加成功
     */
    Boolean add(WebAddReqVO webAddReqVO);
}
