package com.zhut.wjadmin.module.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhut.wjadmin.module.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
