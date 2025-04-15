package com.taylor.common.jwt.manager;

import com.taylor.common.base.cache.RedisTimedCache;

import java.time.Duration;

/**
 * Redisson实现
 *
 * @author loveCamille
 * @date 2025-04-14 10:15:55
 */
public class RedisJwtTokenManager extends RedisTimedCache<String, String> implements JwtTokenManager {

    private static final String JWT_TOKEN_KEY = "common:user:token:";

    public RedisJwtTokenManager(Duration timeout) {
        super(timeout, key -> JWT_TOKEN_KEY + key);
    }

}
