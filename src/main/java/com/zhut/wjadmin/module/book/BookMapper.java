package com.zhut.wjadmin.module.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhut.wjadmin.module.book.damain.Book;
import com.zhut.wjadmin.module.book.damain.RecommendBookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    public IPage<RecommendBookDTO> getRecommendBooks(Page page);
}
