package com.codergm.orderser.aspect

import com.codergm.orderser.external.decoder.CustomErrorDecoder
import feign.Response
import mu.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class ProductAPILogginAspect {

    @Before(value = "execution(* com.codergm.orderser.external.decoder.CustomErrorDecoder.decode(..))")
    fun productErrorDecode(joinPoint: JoinPoint) {
        val logger = KotlinLogging.logger { CustomErrorDecoder::class.qualifiedName }
        val response = joinPoint.args[1] as Response?
        logger.info { "response url: ${response?.request()?.url()}" }
        logger.info { "response headers: ${response?.request()?.headers()}" }
    }
}