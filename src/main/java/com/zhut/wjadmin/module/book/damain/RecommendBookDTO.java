package com.zhut.wjadmin.module.book.damain;

import lombok.Data;

import java.util.Date;

@Data
public class RecommendBookDTO {
    private String title;
    private String author;
    private Date year;
    private String abs;
    private String publisher;
    private String imageUrl;
}
