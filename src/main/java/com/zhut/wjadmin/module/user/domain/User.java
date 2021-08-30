package com.zhut.wjadmin.module.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.zhut.wjadmin.common.domain.Base;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("user_tab")
public class User extends Base {

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

}
