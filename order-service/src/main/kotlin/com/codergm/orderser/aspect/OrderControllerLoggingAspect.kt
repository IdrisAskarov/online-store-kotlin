package com.codergm.orderser.aspect

import com.codergm.orderser.controller.OrderController
import mu.KotlinLogging
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Aspect
@Component
class OrderControllerLoggingAspect {
    var logger = KotlinLogging.logger(OrderController::class.qualifiedName!!)

    @AfterReturning(value = "execution(* com.codergm.orderser.controller.OrderController.placeOrder(..))", returning = "result")
    fun placeOrderLogAroundAfter(result: ResponseEntity<Long>) {
        logger.info { "Order Id: ${result.body}" }
    }
}