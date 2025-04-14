package com.taylor.common.jwt.manager;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

import java.time.Duration;

/**
 * 内存实现
 *
 * @author loveCamille
 * @date 2025-04-14 10:12:48
 */
public class InMemoryJwtTokenManager implements JwtTokenManager {

    private final TimedCache<String, String> cache = CacheUtil.newTimedCache(Duration.ofDays(1).toMillis());

    @Override
    public void put(String username, String jwtToken, Duration duration) {
        cache.put(username, jwtToken, duration.toMillis());
    }

    @Override
    public void remove(String username) {
        cache.remove(username);
    }

    @Override
    public boolean contains(String username) {
        return cache.containsKey(username);
    }
}
