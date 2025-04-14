package com.taylor.common.jwt.manager;

import java.time.Duration;

public interface JwtTokenManager {

    void put(String username, String jwtToken, Duration duration);

    void remove(String username);

    boolean contains(String username);

}
