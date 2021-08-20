package com.zhut.wjadmin.module.book.service;

import com.zhut.wjadmin.module.book.damain.Book;
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

    /**
     * 获取电子书
     * @param count
     * @return
     */
    public List<BookDTO> getEbooks(int count);

    /**
     * 根据id获取book
     * @param bookId
     * @return
     */
    public Book getBookById(int bookId);

    /**
     * 搜索图书
     * @param name
     * @return
     */
    public List<BookDTO> searchBookByName(String name);
}
