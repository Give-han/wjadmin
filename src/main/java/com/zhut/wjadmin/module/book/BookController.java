package com.zhut.wjadmin.module.book;

import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.book.damain.Book;
import com.zhut.wjadmin.module.book.damain.BookDTO;
import com.zhut.wjadmin.module.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取受欢迎图书
     * @param count
     * @return
     */
    @PostMapping("/popularBook/{count}")
    public ResultVo getPopularBooks(@PathVariable("count") int count) {
        List<BookDTO> popularBooks = bookService.getPopularBooks(count);

        return ResultVo.success(popularBooks);
    }

    /**
     * 获取电子图书
     * @return
     */
    @GetMapping("/ebook/{count}")
    public ResultVo getEbooks(@PathVariable("count") int count) {

//        List<BookDTO> ebooks = bookService.getEbooks(count);
        // todo 电子书暂不处理
        List<BookDTO> bookNews = bookService.getBookNews();

        return ResultVo.success(bookNews);
    }

    /**
     * 根据id获取图书
     * @param bookId
     * @return
     */
    @PostMapping("/getById")
    public ResultVo getBookById(@RequestParam Integer bookId) {
        ResultVo resultVo = null;

        try {
            Book book = bookService.getBookById(bookId);
            resultVo = ResultVo.success(book);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultVo.fail("fail");
        }
        return resultVo;
    }

    /**
     * 搜索图书
     * @param name
     * @return
     */
    @PostMapping("/searchBook")
    public ResultVo searchBook(@RequestParam String name) {
        ResultVo resultVo = null;
        try {
            List<BookDTO> books = bookService.searchBookByName(name);
            resultVo = ResultVo.success(books);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultVo.fail("搜索失败");
        }

        return resultVo;
    }
}
