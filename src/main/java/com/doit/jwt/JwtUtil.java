package com.doit.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>描述: [这个类用来完成对token的操作：创建token、验证token、从token中获得user信息] </p>
 * <p>创建时间: 2021/09/27 下午 05:40 </p>
 *
 * @author 李二帅
 * @version v1.0
 */
public class JwtUtil {
    /**
     * 私钥
     */
    public static final String SECRET = "SECRET_VALUE";
    /**
     * 请求头
     */
    public static final String AUTH_HEADER = "X-Authorization-With";
    /**
     * 过期时间 7 天
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;

    /**
     * 生成签名
     */
    public static String sign(String username, String secret) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 设置加密算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 创建token 附带username，nickname信息
            return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证token是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            // 获取算法信息
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 生成JWTVerifier
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            // 验证token
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * 获得token中的自定义信息，无需secret解密也能获得
     */
    public static String getClaimFiled(String token, String filed) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(filed).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取 token的签发时间
     */
    public static Date getIssuedAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getIssuedAt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 验证 token是否过期
     */
    public static boolean isTokenExpired(String token) {
        Date now = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().before(now);
    }

    /**
     * 刷新 token的过期时间
     */
    public static String refreshTokenExpired(String token, String secret) {
        DecodedJWT jwt = JWT.decode(token);
        Map<String, Claim> claims = jwt.getClaims();
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Builder builder = JWT.create().withExpiresAt(date);
            for (Entry<String, Claim> entry : claims.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue().asString());
            }
            return builder.sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }

    /**
     * 生成16位随机盐
     */
    public static String generateSalt() {
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        return secureRandom.nextBytes(16).toHex();
    }
}
