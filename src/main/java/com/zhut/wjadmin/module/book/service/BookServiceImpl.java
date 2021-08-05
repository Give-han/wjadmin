package com.zhut.wjadmin.module.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.book.BookMapper;
import com.zhut.wjadmin.module.book.damain.RecommendBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResultVo getRecommendBooks() {
//        Map<String, List> map = new HashMap<>();
        List<List> list = new ArrayList<>();
        Page<Map> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        IPage<RecommendBookDTO> recommendBooks = bookMapper.getRecommendBooks(page);
        List<RecommendBookDTO> records = recommendBooks.getRecords();
        list.add(records);
//        map.put("1", records);
        page.setCurrent(2);
        page.setSize(10);
        IPage<RecommendBookDTO> recommendBooks2 = bookMapper.getRecommendBooks(page);
        List<RecommendBookDTO> records2 = recommendBooks2.getRecords();
//        map.put("2", records2);
//        map.put("3", records);
//        map.put("4", records2);
        list.add(records2);
        list.add(records);
        list.add(records2);
        return ResultVo.success(list);
    }
}
