package com.taylor.common.jwt.manager;

import com.taylor.common.jwt.JwtProperties;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Redisson实现
 *
 * @author loveCamille
 * @date 2025-04-14 10:15:55
 */
public class RedissonJwtTokenManager implements JwtTokenManager {

    private static final String JWT_TOKEN_KEY = "common:user:token:";

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RedissonClient redisson;

    @Override
    public String getJwtToken(String username) {
        return redisson.getBucket(JWT_TOKEN_KEY + username).get().toString();
    }

    @Override
    public void put(String username, String jwtToken) {
        redisson.getBucket(JWT_TOKEN_KEY + username).set(jwtToken, jwtProperties.getExpireTime());
    }

    @Override
    public void remove(String username) {
        redisson.getBucket(JWT_TOKEN_KEY + username).delete();
    }

    @Override
    public boolean contains(String username) {
        return redisson.getBucket(JWT_TOKEN_KEY + username).isExists();
    }
}
