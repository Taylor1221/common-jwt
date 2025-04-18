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

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 过期时间，比如 30天后 过期 Duration.ofDays(30)
     */
    private Duration expireTime;

    /**
     * 刷新阈值，距离过期时间不到 renewThreshold 时，刷新token
     */
    private Duration renewThreshold = Duration.ofDays(1);

}
