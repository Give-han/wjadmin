package com.zhut.wjadmin;

import com.zhut.wjadmin.module.book.BookMapper;
import com.zhut.wjadmin.module.book.damain.Book;
import com.zhut.wjadmin.module.book.damain.BookDTO;
import com.zhut.wjadmin.module.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
//@Slf4j
class WjadminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setTitle("人造美人");
        book.setAuthor("(日) 星新一");
        book.setPublisher("译林出版社");
        book.setProducer("乐府文化");
        book.setIsTrans(1);
        book.setTranslator("赵建军");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sd.parse("2021-7-15");
            book.setPubYear(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setPageNum(241);
        book.setBinding("平装");
        book.setIsbn("9787544786812");
        book.setAbs("《人造美人》结集了星新一39篇作品，包含《人造美人》《生活维持省》《被热恋的男人》《身份识别机》等。这些短篇题材新颖、知识新鲜、想象新奇，结尾出乎意料；同时立意深刻，读罢让人不禁反思。\n" +
                "\n" +
                "酒吧老板制作了一台美女机器人来招揽生意，可有客人爱上了她……\n" +
                "\n" +
                "未来和平安宁，人人都有开阔的生存空间，活得悠闲自在，这多亏了一个特别的机构——生活维持省。\n" +
                "\n" +
                "博士发明了一种让对方自动爱上自己的药水，他能如愿尝到恋爱的滋味吗？\n" +
                "\n" +
                "高精度的身份识别机被发明了出来，成为社会生活不可或缺的一部分。机器的生产厂家垄断了市场，保密工作无懈可击。然而一场意外让一切都乱了套……");
        book.setPrice(BigDecimal.valueOf(35.50));
        book.setImageUrl("https://img3.doubanio.com/view/subject/l/public/s33955420.jpg");
        book.setScore(8.9);
        bookMapper.insert(book);
    }

    @Test
    public void test() {
        List<BookDTO> popularBook = bookMapper.getPopularBook(10);
        System.out.println(popularBook.size());
    }

}
