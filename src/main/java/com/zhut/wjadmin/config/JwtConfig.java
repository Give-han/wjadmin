package com.zhut.wjadmin.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "config.jwt")
@Data
public class JwtConfig {

    private String secret;
    private long expire;
    private String header;

    /**
     * 生成token
     * @param subject
     * @return
     */
    public String createToken(String subject) {
        Date date = new Date();
        Date expireDate = new Date(System.currentTimeMillis() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "jwt")
                .setSubject(subject)
                .setExpiration(expireDate)
                .setIssuedAt(date)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取token中的注册信息
     * @param token
     * @return
     */
    public Claims getTokenClaim(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 获取注册信息
     * @param token
     * @return
     */
    public String getSubject(String token) {
        return getTokenClaim(token).getSubject();
    }

    /**
     * 验证token是否过期
     * @param expireDate
     * @return
     */
    public Boolean isExpire(Date expireDate) {
        return expireDate.before(new Date());
    }

    /**
     * 获取token失效时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getTokenClaim(token).getExpiration();
    }
    /**
     * 获取用户名从token中
     */
    public String getUsernameFromToken(String token) {
        return getTokenClaim(token).getSubject();
    }

    /**
     * 获取jwt发布时间
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getTokenClaim(token).getIssuedAt();
    }

}
