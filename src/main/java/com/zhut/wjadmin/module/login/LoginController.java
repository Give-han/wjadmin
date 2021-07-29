package com.zhut.wjadmin.module.login;

import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.login.domain.LoginVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginVo loginVo) {
        String userAccount = loginVo.getUseraccount();
        String passWord = loginVo.getPassword();
        if (userAccount.equals("admin") && passWord.equals("abc123")) {
            ResultVo resultVo = ResultVo.success("登录成功");
            return resultVo;
        } else {
            ResultVo resultVo = ResultVo.fail("登录失败");
            return resultVo;
        }
    }
}
