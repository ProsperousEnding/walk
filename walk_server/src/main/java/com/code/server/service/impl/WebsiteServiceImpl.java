package com.code.server.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.server.entity.WebCate;
import com.code.server.entity.Website;
import com.code.server.mapper.WebsiteMapper;
import com.code.server.pojo.vo.req.PageReqVO;
import com.code.server.pojo.vo.req.WebAddReqVO;
import com.code.server.service.WebCateService;
import com.code.server.service.WebsiteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * 网址Mapper
     */
    private final WebsiteMapper websiteMapper;

    /**
     * 网址_分类Service
     */
    private final WebCateService webCateService;

    /**
     * 查询导航
     *
     * @param pageReqVO 分页条件
     * @return Page<Website> 分页数据
     */
    @Override
    public Page<Website> queryNav(PageReqVO pageReqVO) {
        Page<Website> page = new Page<>(pageReqVO.getPageNum(), pageReqVO.getPageSize());
        return websiteMapper.selectPage(page, null);
    }


    /**
     * 添加网址
     *
     * @param webAddReqVO 添加网址请求
     * @return Boolean
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public Boolean add(WebAddReqVO webAddReqVO) {
        Website website = BeanUtil.copyProperties(webAddReqVO, Website.class);
        if (ObjectUtil.isEmpty(website.getIco()) && ObjectUtil.isNotEmpty(website.getCover())) {
            website.setIco(website.getCover());
        }
        websiteMapper.insert(website);
        Long webId = website.getId();
        List<Long> categoryIds = webAddReqVO.getCategoryIds();
        List<WebCate> webCateList = new ArrayList<>();
        for (Long categoryId : categoryIds) {
            WebCate webCate = new WebCate();
            webCate.setWebId(webId);
            webCate.setCateId(categoryId);
            webCateList.add(webCate);
        }
        return webCateService.saveBatch(webCateList);
    }


}




