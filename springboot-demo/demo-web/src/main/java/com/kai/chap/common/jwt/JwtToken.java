package com.kai.chap.common.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Token封装类
 * @author hongok
 * @since 2018-12-21 14:57:55
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
