package com.zhut.wjadmin.module.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhut.wjadmin.module.book.BookMapper;
import com.zhut.wjadmin.module.book.damain.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getRecommendBooks(int pageNum, int size) {
        Page<Map> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(size);
        IPage<BookDTO> recommendBooks = bookMapper.getRecommendBooks(page);
        List<BookDTO> records = recommendBooks.getRecords();
        return records;
    }

    @Override
    public List<BookDTO> getBookNews() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        // todo 伪造数据
        BookDTO bookNew = new BookDTO();
        bookNew.setTitle("隐隐约约有熊在冰面上");
        bookNew.setAuthor("沈大成");
        bookNew.setImageUrl("https://img9.doubanio.com/view/subject/l/public/s33951105.jpg");
        bookNew.setAbs("有一个自我描述“理东西理不彻底”的朋友，她住在乡下大房子里，有很多书、小家电、画具、衣服，有一天她问我有关理东西的问题：你还有别人，怎么确定出一本短篇小说集的？她的意思是，为什么决定把这些收在一起出？\n" +
                "\n" +
                "我会做一个Excel表格，列出已经写好的小说篇名，列出各篇的关键词、人物、字数等等，它是非常简单的，任何人学习Excel五分钟就能做好。我看着它，依照心里一条大概的线索，选取篇目。然后我再改几遍，使大家放在一起更合适。");
        bookDTOS.add(bookNew);
        bookDTOS.add(bookNew);
        bookDTOS.add(bookNew);
        bookDTOS.add(bookNew);

        return bookDTOS;
    }

    @Override
    public List<BookDTO> getPopularBooks(int count) {
        List<BookDTO> popularBook = bookMapper.getPopularBook(count);
        return popularBook;
    }
}
