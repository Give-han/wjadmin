package com.zhut.wjadmin.module.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhut.wjadmin.module.user.UserMapper;
import com.zhut.wjadmin.module.user.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByNameOrAccount(String name, String password) {
        if (StringUtils.isNoneEmpty(name)) {
            QueryWrapper<User> qw = new QueryWrapper();
            qw.eq("user_name", name).or().eq("user_account", name);
            qw.eq("password", password);

            List<User> users = userMapper.selectList(qw);

            User user = users.get(0);
            return user;
        }
        return null;
    }
}
