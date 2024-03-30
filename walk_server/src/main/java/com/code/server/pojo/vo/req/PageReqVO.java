package com.code.server.pojo.vo.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageReqVO {

    /**
     * 页数
     */
    Integer pageNum;

    /**
     * 容量
     */
    Integer pageSize;
}
