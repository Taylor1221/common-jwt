package com.taylor.jwt;

import com.auth0.jwt.algorithms.Algorithm;

/**
 * 默认JWT提供
 * @author loveCamille
 * @date 2025-04-03 16:00:54
 */
public class DefaultJwtProvider extends AbstractJwtProvider {

    @Override
    protected Algorithm buildAlgorithm(JwtProperties jwtProperties) {
        return Algorithm.HMAC256(jwtProperties.getSecretKey());
    }
}
