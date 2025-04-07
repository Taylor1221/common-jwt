package com.taylor.common.jwt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JWT相关组件自动配置
 *
 * @author loveCamille
 * @date 2025-04-03 15:24:36
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(JwtProvider.class)
    public JwtProvider jwtProvider() {
        return new DefaultJwtProvider();
    }

}
