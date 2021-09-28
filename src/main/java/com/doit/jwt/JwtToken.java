package com.doit.jwt;


import org.apache.shiro.authc.AuthenticationToken;

import java.io.Serial;

/**
 * <p>描述: [ AuthenticationToken 接口的实现类 ] </p>
 * <p>创建时间: 2021/09/27 下午 05:39 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public class JwtToken implements AuthenticationToken {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 加密后的 JWT token串
     */
    private final String token;
    private final String userName;

    public JwtToken(String token) {
        this.token = token;
        this.userName = JwtUtil.getClaimFiled(token, "username");
    }

    @Override
    public Object getPrincipal() {
        return this.userName;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}