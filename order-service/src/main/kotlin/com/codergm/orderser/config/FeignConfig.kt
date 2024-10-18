package com.codergm.orderser.config

import com.codergm.orderser.external.decoder.CustomErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
    @Bean
    fun errorDecoder() = CustomErrorDecoder()
}