package com.taylor.common.jwt.manager;

import com.taylor.common.base.cache.AbstractTimedCache;
import com.taylor.common.base.cache.factory.ICommonTimedCacheFactory;

import java.time.Duration;

/**
 * token管理器实现
 *
 * @author loveCamille
 * @date 2025-04-16 23:41:27
 */
public class JwtTokenManagerImpl extends AbstractTimedCache<String, String> implements JwtTokenManager {

    private static final String JWT_TOKEN_KEY_PREFIX = "common:user:token:";

    public JwtTokenManagerImpl(Duration timeout, ICommonTimedCacheFactory factory) {
        super(timeout, factory, key -> JWT_TOKEN_KEY_PREFIX + key);
    }

}
