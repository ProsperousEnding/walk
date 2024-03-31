package com.code.server.controller;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.server.entity.Website;
import com.code.server.pojo.vo.req.PageReqVO;
import com.code.server.service.WebsiteService;
import com.code.server.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/website")
public record WebsiteController(
        WebsiteService websiteService
) {
    @PostMapping(value = "/nav")
    public ResultUtils queryNav(@RequestBody PageReqVO page) {
        Assert.notNull(page);
        Page<Website> nav = websiteService.queryNav(page);
        return ResultUtils.success(nav);
    }
}
