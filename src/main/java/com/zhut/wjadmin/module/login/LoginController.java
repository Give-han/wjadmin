package com.zhut.wjadmin.module.login;

import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.login.domain.LoginVo;
import com.zhut.wjadmin.module.user.UserMapper;
import com.zhut.wjadmin.module.user.domain.User;
import com.zhut.wjadmin.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户名或账号登录
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginVo loginVo) {
        String userAccount = loginVo.getUseraccount();
        String passWord = loginVo.getPassword();

        User user = userService.getUserByNameOrAccount(userAccount, passWord);

        if (user != null) {
            ResultVo resultVo = ResultVo.success("登录成功");
            return resultVo;
        } else {
            ResultVo resultVo = ResultVo.fail("登录失败");
            return resultVo;
        }
    }
}
