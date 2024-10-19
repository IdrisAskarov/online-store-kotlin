package com.codergm.productser.config

import feign.Capability
import feign.micrometer.MicrometerCapability
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Bean
    fun capability(registry: MeterRegistry): Capability {
        return MicrometerCapability(registry);
    }
}