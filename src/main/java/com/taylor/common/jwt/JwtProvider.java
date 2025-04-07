package com.taylor.common.jwt;

import org.springframework.lang.NonNull;

/**
 *  JWT 生成、校验、解析接口
 *
 * @author loveCamille
 * @date 2025-04-03 15:32:52
 */
public interface JwtProvider {

    /**
     * 根据username生成 token
     * @author loveCamille
     * @param username 用户名
     * @return {@link String} token
    */
    String generateToken(@NonNull String username);

    /**
     * 校验token
     * @author loveCamille
     * @param username 用户名
     * @return 校验是否成功
    */
    boolean validateToken(@NonNull String username);

    /**
     * 根据token解析用户名
     * @author loveCamille
     * @param token token令牌
     * @return {@link String} 用户名
    */
    String getUsername(@NonNull String token);

}
