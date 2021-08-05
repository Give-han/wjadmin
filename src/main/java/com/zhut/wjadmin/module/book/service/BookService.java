package com.zhut.wjadmin.module.book.service;

import com.zhut.wjadmin.common.domain.ResultVo;

import java.util.List;

public interface BookService {

    /**
     * 获取推荐图书
     * @return
     */
    public ResultVo getRecommendBooks();
}
