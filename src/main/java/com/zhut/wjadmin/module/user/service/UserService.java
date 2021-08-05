package com.zhut.wjadmin.module.user.service;

import com.zhut.wjadmin.module.user.domain.User;

public interface UserService {

    User getUserByNameOrAccount(String name, String password);
}
