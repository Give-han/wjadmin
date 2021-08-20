package com.zhut.wjadmin.module.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhut.wjadmin.module.book.damain.Book;
import com.zhut.wjadmin.module.book.damain.BookDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    public IPage<BookDTO> getRecommendBooks(Page page);

    public List<BookDTO> getPopularBook(@Param("count") int count);

    public List<BookDTO> getBooksByMap(@Param("params") Map<String, Object> map);

    public List<BookDTO> searchBookByName(@Param("name") String name);
}
