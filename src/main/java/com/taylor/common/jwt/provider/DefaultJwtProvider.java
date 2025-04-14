package com.taylor.common.jwt.provider;

import com.auth0.jwt.algorithms.Algorithm;
import com.taylor.common.jwt.JwtProperties;

/**
 * 默认JWT提供
 * @author loveCamille
 * @date 2025-04-03 16:00:54
 */
public class DefaultJwtProvider extends AbstractJwtProvider {

    public DefaultJwtProvider(JwtProperties jwtProperties) {
        super(jwtProperties);
    }

    @Override
    protected Algorithm buildAlgorithm(JwtProperties jwtProperties) {
        return Algorithm.HMAC256(jwtProperties.getSecretKey());
    }
}
