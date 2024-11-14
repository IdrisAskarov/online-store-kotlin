package com.codergm.orderser.aspect

import com.codergm.orderser.domain.entity.OrderEntity
import com.codergm.orderser.service.impl.OrderServiceImpl
import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class OrderServiceLoggingAspect {
    val logger = KotlinLogging.logger(OrderServiceImpl::class.qualifiedName!!)

    @Around("execution(* com.codergm.orderser.service.impl.OrderServiceImpl.save(..))")
    fun saveLoggingAspect(joinPoint: ProceedingJoinPoint): Any?{
        val order = joinPoint.args[0] as OrderEntity
        logger.info { "Saving order: $order" }
        return joinPoint.proceed()
    }

    @Around("execution(* com.codergm.orderser.service.impl.OrderServiceImpl.getOrderDetails(..))")
    fun orderDetailsLogging(joinPoint: ProceedingJoinPoint): Any?{
        val orderId = joinPoint.args[0] as Long

        logger.info { "Getting order details for Order Id : $orderId" }

        val result = joinPoint.proceed()

        return result
    }
}