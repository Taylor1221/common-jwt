package com.taylor.common.jwt.manager;


import com.taylor.common.base.cache.ICommonTimedCache;

public interface JwtTokenManager extends ICommonTimedCache<String, String> {
}
