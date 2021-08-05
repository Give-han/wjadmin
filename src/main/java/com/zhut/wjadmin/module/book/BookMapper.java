package com.zhut.wjadmin.module.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhut.wjadmin.module.book.damain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    public List<Map<String, Object>> getRecommendBooks();
}
