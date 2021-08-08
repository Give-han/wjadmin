package com.zhut.wjadmin.module.book;

import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.book.damain.BookDTO;
import com.zhut.wjadmin.module.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/recommendBook")
    public ResultVo getRecommendNewBooks() {
        // 获取四页数据，每页封装在一个list
        List<List> resultList = new ArrayList<>();
        List<BookDTO> recommend1 = bookService.getRecommendBooks(1, 10);
        List<BookDTO> recommend2 = bookService.getRecommendBooks(2, 10);

        // todo 带获取更多数据
        resultList.add(recommend1);
        resultList.add(recommend2);
        resultList.add(recommend1);
        resultList.add(recommend2);

        return ResultVo.success(resultList);
    }

    /**
     * 获取图书咨询
     * @return
     */
    @GetMapping("/bookNews")
    public ResultVo getBookNews() {
        try {
            List<BookDTO> bookNews = bookService.getBookNews();
            return ResultVo.success(bookNews);
        } catch (Exception e) {
            return ResultVo.fail("获取失败");
        }
    }

    @PostMapping("/popularBook/{count}")
    public ResultVo getPopularBooks(@PathVariable("count") int count) {
        List<BookDTO> popularBooks = bookService.getPopularBooks(count);

        return ResultVo.success(popularBooks);
    }

    /**
     * 获取电子图书
     * @return
     */
    @GetMapping("/ebook")
    public ResultVo getEbooks() {

        return ResultVo.success(null);
    }

}
