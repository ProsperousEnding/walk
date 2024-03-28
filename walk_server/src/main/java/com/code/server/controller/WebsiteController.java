package com.code.server.controller;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.server.pojo.vo.req.PageReqVO;
import com.code.server.service.WebsiteService;
import com.code.server.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record WebsiteController(
        WebsiteService websiteService
) {
    @GetMapping(value = "/nav")
    public ResultUtils queryNav(@RequestBody PageReqVO page) {
        Assert.notNull(page);
        Page navPage = websiteService.queryNav(page);
        return ResultUtils.success();
    }
}
