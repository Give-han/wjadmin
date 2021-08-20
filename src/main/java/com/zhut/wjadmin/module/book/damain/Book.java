package com.zhut.wjadmin.module.book.damain;

import com.baomidou.mybatisplus.annotation.*;
import com.zhut.wjadmin.common.domain.Base;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Book
 */
@Data
@TableName("book")
public class Book extends Base {

    // id
    @TableId(value = "book_id", type = IdType.AUTO)
    private int bookId;

    // 书名
    private String title;

    // 出版社
    private String publisher;

    // 出品方
    private String producer;

    // 作者
    private String author;

    // 是否翻译 1:是， 0:否
    private int isTrans;

    // 译者
    private String translator;

    // 出版年
    @TableField("pub_year")
    private Date pubYear;

    // 是否电子书
    @TableField("is_ebook")
    private int isEbook;

    // 提供方
    private String supplier;

    // 字数
    @TableField("words_num")
    private String wordsNum;

    // 页数
    @TableField("page_num")
    private Integer pageNum;

    // 定价
    private BigDecimal price;

    // 装帧
    private String binding;

    // ISBN
    private String isbn;

    // 图片
    @TableField("image_url")
    private String imageUrl;

    // 内容简介
    private String abs;

    // 评分
    private double score;

}
