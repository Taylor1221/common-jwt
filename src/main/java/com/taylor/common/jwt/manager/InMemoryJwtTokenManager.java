package com.taylor.common.jwt.manager;

import cn.hutool.cache.CacheUtil;
import com.taylor.common.base.cache.InMemoryTimedCache;

import java.time.Duration;

/**
 * 内存实现
 *
 * @author loveCamille
 * @date 2025-04-14 10:12:48
 */
public class InMemoryJwtTokenManager extends InMemoryTimedCache<String, String> implements JwtTokenManager {

    public InMemoryJwtTokenManager(Duration timeout) {
        super(CacheUtil.newTimedCache(timeout.toMillis()));
    }

}
