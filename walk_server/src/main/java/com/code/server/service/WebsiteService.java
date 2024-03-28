package com.code.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.server.pojo.vo.req.PageReqVO;

public interface WebsiteService {

    Page queryNav(PageReqVO page);
}
