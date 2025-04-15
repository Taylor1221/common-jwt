package com.taylor.common.jwt.manager;


import com.taylor.common.base.cache.ICommonTimedCache;

public interface JwtTokenManager extends ICommonTimedCache<String, String> {

    String get(String username);

    void put(String username, String jwtToken);

    void remove(String username);

    boolean contains(String username);

}
