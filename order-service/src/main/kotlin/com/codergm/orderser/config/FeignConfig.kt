package com.codergm.orderser.config

import com.codergm.orderser.external.decoder.CustomErrorDecoder
import feign.Capability

import feign.micrometer.MicrometerCapability
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
    @Bean
    fun errorDecoder() = CustomErrorDecoder()

    @Bean
    fun capability(registry: MeterRegistry): Capability {
        return MicrometerCapability(registry);
    }
}