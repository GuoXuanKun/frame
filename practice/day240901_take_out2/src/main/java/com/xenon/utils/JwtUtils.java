package com.xenon.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * @author wuyunbin
 */
@Slf4j
@Component
public class JwtUtils {
    /**
     * 生成JWT
     * @param id 用户id
     * @param claims 相当于一个map
     * @param ttl 有效期
     * @param secretKey 密钥
     * @return token字符串
     */
    public  String createJwt(String id, Claims claims, Long ttl, String secretKey) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .setId(id)
                .setClaims(claims)
                //签发时间
                .setIssuedAt(new Date())
                //.setExpiration(new Date(System.currentTimeMillis() + ttl))
                .signWith(key)
                .compact();
    }

    /**
     * 解析JWT
     * @param token token字符串
     * @param secretKey 密钥
     * @return Claims
     */

    public  Claims parseJwt(String token, String secretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 验证token是否有效
     * @param token token字符串
     * @param secretKey 密钥
     * @return boolean true-有效 false-失效
     */
    public  boolean validateToken(String token, String secretKey) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey.getBytes())
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}