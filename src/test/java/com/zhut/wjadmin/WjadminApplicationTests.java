package com.zhut.wjadmin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhut.wjadmin.module.book.BookMapper;
import com.zhut.wjadmin.module.book.damain.Book;
import com.zhut.wjadmin.module.book.damain.BookDTO;
import com.zhut.wjadmin.module.tag.TagMapper;
import com.zhut.wjadmin.module.tag.domain.Tag;
import com.zhut.wjadmin.module.tag.domain.TagCatoryConst;
import com.zhut.wjadmin.module.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
//@Slf4j
class WjadminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private TagMapper tagMapper;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setTitle("达摩流浪者");
        book.setIsEbook(1);
        book.setAuthor("[美] 杰克·凯鲁亚克");
        book.setPublisher("湖南科学技术出版社 ");
        book.setSupplier("浦睿文化");
        book.setIsTrans(1);
        book.setTranslator("业之");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sd.parse("2021-5-6");
            book.setPubYear(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setWordsNum("144,000");
//        book.setBinding("平装");
        book.setIsbn("9787571001933");
        book.setAbs("1957年，《在路上》出版，让“垮掉的一代”登上文学版图，并让凯鲁亚克跻身畅销作家之列。仅一年后，《达摩流浪者》出版。相比前作，这部小说具有同样的开阔、幽默和对生活的感人热情，故事则更有凝聚力，讲述了两个年轻人对佛法或真理的激情探寻。他们的冒险集中在对禅的追求，这最终引导他们攀上内华达山脉，去体悟孤独之道。");
        book.setPrice(BigDecimal.valueOf(35.50));
        book.setImageUrl("https://img9.doubanio.com/view/subject/l/public/s33896395.jpg");
        book.setScore(8.9);
        bookMapper.insert(book);
    }

    @Test
    public void initTag() {
        String[] item1 = {"小说","随笔","日本文学","散文","诗歌","童话","名著","港台"};
        String[] item2 = {"漫画","推理","绘本","青春","科幻","言情","奇侠","武侠"};
        String[] item3 = {"历史","哲学","建筑","传记","设计","电影","回忆录","音乐"};
        String[] item4 = {"旅行","励志","教育","职场","美食","灵修","健康","家居"};
        String[] item5 = {"经济学","管理","商业","金融","营销","理财","股票","企业史"};
        String[] item6 = {"科普","互联网","编程","交互设计","算法","通信","神经网络","程序"};
        for (int i = 0; i < item2.length; i++) {
            Tag tag = new Tag();
            tag.setTagName(item2[i]);
            tag.setCategory(TagCatoryConst.POPULAR);
            tagMapper.insert(tag);
        }
        for (int i = 0; i < item3.length; i++) {
            Tag tag = new Tag();
            tag.setTagName(item3[i]);
            tag.setCategory(TagCatoryConst.CULTURE);
            tagMapper.insert(tag);
        }
        for (int i = 0; i < item4.length; i++) {
            Tag tag = new Tag();
            tag.setTagName(item4[i]);
            tag.setCategory(TagCatoryConst.LIFE);
            tagMapper.insert(tag);
        }
        for (int i = 0; i < item5.length; i++) {
            Tag tag = new Tag();
            tag.setTagName(item5[i]);
            tag.setCategory(TagCatoryConst.ECONOMIC);
            tagMapper.insert(tag);
        }
        for (int i = 0; i < item6.length; i++) {
            Tag tag = new Tag();
            tag.setTagName(item6[i]);
            tag.setCategory(TagCatoryConst.TOCHNOLOGY);
            tagMapper.insert(tag);
        }
    }

    @Test
    public void test() {
        List<Map<String, Object>> list = new ArrayList<>();
        // 首页tag类别
        String[] category = {"文学","流行","文化","生活","经管","科技"};
        // 首页每个类别默认展示8个
        for (int i = 0; i < category.length; i++) {
            Map<String, Object> map = new HashMap<>();
            String cate = category[i];
            Page<Map> page = new Page<>();
            page.setSize(8);
            page.setCurrent(1);
            IPage<Map> tagsByCategory = tagMapper.getTagsByCategory(page, cate);
            List<Map> records = tagsByCategory.getRecords();
            map.put("category", cate);
            map.put("tags", records);
            list.add(map);
        }
        System.out.println(list);
    }

}
