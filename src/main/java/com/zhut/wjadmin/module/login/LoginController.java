package com.zhut.wjadmin.module.login;

import com.zhut.wjadmin.module.login.domain.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginVo loginVo) {
        System.out.println(loginVo);
    }
}
