package com.code.server.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.server.entity.Website;
import com.code.server.pojo.vo.req.PageReqVO;
import com.code.server.pojo.vo.req.WebAddReqVO;
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

    /**
     * 查询导航
     *
     * @param page 分页请求
     */
    @PostMapping(value = "/nav")
    public ResultUtils<Page<Website>> queryNav(@RequestBody PageReqVO page) {
        Assert.notNull(page);
        Page<Website> nav = websiteService.queryNav(page);
        return ResultUtils.success(nav);
    }

    /**
     * 添加导航
     *
     * @param req 添加请求
     */
    @PostMapping(value = "/add")
    public ResultUtils<Void> add(@RequestBody WebAddReqVO req) {
        Assert.notNull(req);
        Boolean add = websiteService.add(req);
        if (BooleanUtil.isTrue(add)) {
            return ResultUtils.success();
        } else {
            return ResultUtils.fail();
        }
    }
}
