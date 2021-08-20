package com.zhut.wjadmin.module.book.damain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 推荐书籍DTO
 */
@Data
public class BookDTO {

    private int bookId;

    private String title;

    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date year;

    private String abs;

    private String publisher;

    private String imageUrl;

    // 评分
    private double score;

    private BigDecimal price;
}
