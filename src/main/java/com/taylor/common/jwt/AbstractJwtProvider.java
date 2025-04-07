package com.taylor.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.InitializingBean;

import java.util.Date;

/**
 * 抽象JWT 生成、校验、解析接口实现
 *
 * @author loveCamille
 * @date 2025-04-03 15:43:51
 */
public abstract class AbstractJwtProvider implements JwtProvider, InitializingBean {

    protected final JwtProperties jwtProperties;

    private Algorithm algorithm;

    private JWTVerifier verifier;

    public AbstractJwtProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    /**
     * 允许子类定制不同的签名算法
     * @author loveCamille
     * @param jwtProperties jwt配置
     * @return {@link Algorithm} 签名算法
    */
    protected abstract Algorithm buildAlgorithm(JwtProperties jwtProperties);

    @Override
    public void afterPropertiesSet() {
        this.algorithm = buildAlgorithm(jwtProperties);
        this.verifier = JWT.require(algorithm).build();
    }

    @Override
    public String generateToken(String username) {
        JWTCreator.Builder builder = JWT.create()
                .withSubject(username) // 设置用户名
                .withIssuedAt(new Date()); // 签发时间
        if (jwtProperties.getExpireTime() != null) {
            // 设置过期时间
            builder.withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpireTime().toMillis()));
        }
        return builder.sign(algorithm);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    @Override
    public String getUsername(String token) {
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getSubject();
    }
}
