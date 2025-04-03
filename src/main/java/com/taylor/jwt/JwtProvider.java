package com.taylor.jwt;

import org.springframework.lang.NonNull;

/**
 *  JWT 生成、校验、解析接口
 *
 * @author loveCamille
 * @date 2025-04-03 15:32:52
 */
public interface JwtProvider {

    /**
     * 根据用户id生成 token
     * @author loveCamille
     * @param userId 用户id
     * @return {@link String} token
    */
    String generateToken(@NonNull Long userId);

    /**
     * 校验token
     * @author loveCamille
     * @param token token令牌
     * @return 校验是否成功
    */
    boolean validateToken(@NonNull String token);

    /**
     * 根据token解析用户Id
     * @author loveCamille
     * @param token token令牌
     * @return {@link Long} 用户id
    */
    Long getUserId(@NonNull String token);

}
