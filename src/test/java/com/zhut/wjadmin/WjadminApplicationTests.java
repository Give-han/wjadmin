package com.zhut.wjadmin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhut.wjadmin.module.book.BookMapper;
import com.zhut.wjadmin.module.book.damain.Book;
import com.zhut.wjadmin.module.user.UserMapper;
import com.zhut.wjadmin.module.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        book.setTitle("梅里雪山");
        book.setAuthor("[日]小林尚礼");
        book.setPublisher("北京联合出版公司");
        book.setProducer("乐府文化");
        book.setIsTrans(1);
        book.setTranslator("乌尼尔");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sd.parse("2021-5-15");
            book.setPubYear(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setPageNum(400);
        book.setBinding("精装");
        book.setIsbn("9787559648426");
        book.setAbs("1991年1月，云南梅里雪山发生了震惊世界的登山事故，中日友好联合登山队十七名队员遭遇雪崩，全部遇难。这是人类登山史上的第二大山难。在一百多年的现代登山史上，梅里雪山也成为人类唯一无法登顶的山峰。事故发生后，中日双方进行了多方搜索。搜索队伍中一位名叫小林尚礼的日本登山队员，更在之后的二十多年里，为了让山难队友们的亡灵回到亲人身边，一再深入梅里雪山搜寻，并已成功找到了十六具遗体。《梅里雪山：寻找十七位友人》，就是小林尚礼多年艰辛搜寻的记录。本书以纪录片式平实而细腻的文字，壮美与温柔兼具的影像，记录了令人心碎的恐怖山难，艰辛的搜寻，梅里雪山的神秘风貌，山脚下人们的朴素生活，三次转山之旅和当地生活的变化。在跨越多年的搜寻中，他从傲慢的外来登山者，逐渐转变成为神山的守护者，一位自然主题的摄影师和作家。而雪山之残酷与神圣，自然对其心灵和生活的荡涤，也同样荡涤每一个热爱雪山、热爱自然的灵魂。");
        book.setPrice(BigDecimal.valueOf(88.00));
        book.setImageUrl("https://img1.doubanio.com/view/subject/l/public/s4045138.jpg");
        bookMapper.insert(book);
    }

    @Test
    public void test() {
//        List<Map<String, Object>> recommendBooks = bookMapper.getRecommendBooks();
//        System.out.println(recommendBooks);
    }

}
