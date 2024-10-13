package com.codergm.orderser.aspect

import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.service.impl.OrderManagerServiceImpl
import mu.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component

@Aspect
@Component
class OrderManagerServiceLoggingAspect {

    val logger = KotlinLogging.logger(OrderManagerServiceImpl::class.qualifiedName!!)

    @Before("execution(* com.codergm.orderser.service.impl.OrderManagerServiceImpl.placeOrder(..))")
    fun placeOrderLoggingAspectBefore(joinPoint: JoinPoint) {
        val orderRequest = joinPoint.args[0] as OrderRequest
        logger.info { "placing order $orderRequest" }
    }

    @AfterReturning(
        value = "execution(* com.codergm.orderser.service.impl.OrderManagerServiceImpl.placeOrder(..))",
        returning = "result"
    )
    fun placeOrderLoggingAspectAfter(result: Long) {
        logger.info { "order placed successfully with orderId $result" }

    }

}