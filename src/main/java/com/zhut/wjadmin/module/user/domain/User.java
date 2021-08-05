package com.zhut.wjadmin.module.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("user_tab")
public class User {

    /**
     * UUID(主键)
     */
    @TableId(type = IdType.ASSIGN_UUID, value = "uid")
    private String uid;

    /**
     * 名字
     */
    @TableField("user_name")
    private String userName;

    /**
     * password
     */
    @TableField("password")
    private String password;

    /**
     * account
     */
    @TableField("user_account")
    private String userAccount;

    @TableField("age")
    private int age;

    /**
     * 地址
     */
    @TableField("addr")
    private String addr;

    @TableField("phone")
    private String phone;

    @TableField("birthday")
    private Date birthday;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 注意：mybatis自动填充为LocalDateTime
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

//    @TableLogic
    private String state;
}
