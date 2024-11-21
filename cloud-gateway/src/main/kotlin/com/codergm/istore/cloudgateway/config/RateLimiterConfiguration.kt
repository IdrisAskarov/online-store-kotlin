package com.codergm.istore.cloudgateway.config

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono

@Configuration
class RateLimiterConfiguration {

    @Bean
    fun userKeyResolver2(): KeyResolver {
        return KeyResolver { Mono.just("userKey")}
    }

}