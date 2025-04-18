package com.taylor.common.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * JWT配置属性
 *
 * @author loveCamille
 * @date 2025-04-03 15:23:38
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "common.jwt")
public class JwtProperties {

    private String secretKey;

    private Duration expireTime;

    private Duration renewThreshold = Duration.ofDays(30);

}
