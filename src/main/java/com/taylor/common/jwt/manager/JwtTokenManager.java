package com.taylor.common.jwt.manager;


public interface JwtTokenManager {

    void put(String username, String jwtToken);

    void remove(String username);

    boolean contains(String username);

}
