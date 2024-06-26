package com.code.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.code.server.entity.Website;
import com.code.server.pojo.vo.req.PageReqVO;

/**
 * @author ProsperousEnding
 * @description 针对表【web_website(网址表)】的数据库操作Service
 * @createDate 2024-03-30 23:51:55
 */
public interface WebsiteService extends IService<Website> {

    Page<Website> queryNav(PageReqVO page);
}
