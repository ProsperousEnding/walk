package com.code.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.server.entity.Website;
import com.code.server.mapper.WebsiteMapper;
import com.code.server.pojo.vo.req.PageReqVO;
import com.code.server.service.WebsiteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ProsperousEnding
 * @description 针对表【web_website(网址表)】的数据库操作Service实现
 * @createDate 2024-03-30 23:51:55
 */
@Service
@RequiredArgsConstructor
public class WebsiteServiceImpl extends ServiceImpl<WebsiteMapper, Website>
        implements WebsiteService {

    private final WebsiteMapper websiteMapper;

    @Override
    public PageInfo<Website> queryNav(PageReqVO page) {
        PageHelper.startPage(page);
        List<Website> websites = websiteMapper.selectList(new QueryWrapper<>());
        PageInfo<Website> websitePageInfo = new PageInfo<>(websites);
        return websitePageInfo;
    }
}




