package com.zhut.wjadmin.module.book;

import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获取每日新书推荐
     * @return
     */
    @GetMapping("/RecommendBook")
    private ResultVo getRecommendNewBooks() {
        List<Object> recommendBooks = bookService.getRecommendBooks();
        return null;
    }

}
