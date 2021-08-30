package com.zhut.wjadmin.module.login;

import com.alibaba.fastjson.JSONObject;
import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.config.JwtConfig;
import com.zhut.wjadmin.module.login.domain.LoginVo;
import com.zhut.wjadmin.module.user.UserMapper;
import com.zhut.wjadmin.module.user.domain.User;
import com.zhut.wjadmin.module.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Resource
    private JwtConfig jwtConfig;

    /**
     * 用户名或账号登录
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginVo loginVo) {
        JSONObject jsonObject = new JSONObject();
        String userAccount = loginVo.getUseraccount();
        String passWord = loginVo.getPassword();

        User user = userService.getUserByNameOrAccount(userAccount, passWord);

        if (user != null) {
            String token = jwtConfig.createToken(user.getUid());
            if (StringUtils.isNotBlank(token)) {
                jsonObject.put("token", token);
            }
            ResultVo resultVo = ResultVo.success("登录成功", jsonObject);
            return resultVo;
        } else {
            ResultVo resultVo = ResultVo.fail("登录失败");
            return resultVo;
        }
    }
}
