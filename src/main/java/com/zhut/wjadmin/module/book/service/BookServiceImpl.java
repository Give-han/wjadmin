package com.zhut.wjadmin.module.book.service;

import com.zhut.wjadmin.module.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Object> getRecommendBooks() {


        return null;
    }
}
