package com.codergm.paymentser.aspect

import com.codergm.paymentser.domain.entity.TransactionDetailsEntity
import com.codergm.paymentser.service.PaymentService
import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class PaymentServiceLoggingAspect {
    private val logger = KotlinLogging.logger { PaymentService::class.qualifiedName }

    @Around("execution(* com.codergm.paymentser.service.impl.PaymentServiceImpl.doPayment(..))")
    fun doPayment(joinPoint: ProceedingJoinPoint): Any {
        val transactionDetailsEntity = joinPoint.args[0] as TransactionDetailsEntity
        logger.info { "Recording payment details: $transactionDetailsEntity" }
        val result = joinPoint.proceed()
        logger.info { "Transaction Completed with Id ${transactionDetailsEntity.id}" }
        return result
    }
}