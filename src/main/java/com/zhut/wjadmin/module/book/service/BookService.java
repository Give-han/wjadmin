package com.zhut.wjadmin.module.book.service;

import com.zhut.wjadmin.module.book.damain.BookDTO;

import java.util.List;

public interface BookService {

    /**
     * 获取推荐图书
     * @return
     */
    public List<BookDTO> getRecommendBooks(int pageNum, int size);

    /**
     * 获取图书资讯
     * @return
     */
    public List<BookDTO> getBookNews();

    /**
     * 获取最受欢迎图书
     * @param count
     * @return
     */
    public List<BookDTO> getPopularBooks(int count);
}
