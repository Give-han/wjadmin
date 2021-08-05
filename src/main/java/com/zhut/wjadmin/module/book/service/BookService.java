package com.zhut.wjadmin.module.book.service;

import java.util.List;

public interface BookService {

    /**
     * 获取推荐图书
     * @return
     */
    public List<Object> getRecommendBooks();
}
