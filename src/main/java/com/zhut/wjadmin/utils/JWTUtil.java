package com.zhut.wjadmin.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JWTUtil {

    // 密匙secret
    private static final String SECRET = "wjadmin_secret";

    // 过期时间
    private static final long EXPIRATION = 3600L;

    public static String createToken(String uid, String userName, String password) {
        String token = "";
        // header
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");
        token = JWT.create()
                .withHeader(headerMap)
                .withAudience(uid)
                // 私有
                .withClaim("account", userName)
                .withClaim("password", password)
                // 过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                // 签发时间
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public static String getUid() {
        HttpServletRequest request = SpringContentUtil.getHttpServletRequest();
        // 从请求头部中获取token信息
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            return null;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            if (null != jwt) {
                // 拿到我们放置在token中的信息
                List<String> audience = jwt.getAudience();
                if (CollectionUtil.isNotEmpty(audience)) {
                    return audience.get(0);
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return null;
    }



}
