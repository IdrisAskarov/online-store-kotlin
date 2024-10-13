package com.codergm.productser.aspect

import com.codergm.productser.service.impl.ProductServiceImpl
import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class ProductServiceLoggingAspect {
        private val logger = KotlinLogging.logger(ProductServiceImpl::class.qualifiedName!!)


    @Around("execution(* com.codergm.productser.service.impl.ProductServiceImpl.getProductById(..))")
    fun getProductByIdLogAround(joinPoint: ProceedingJoinPoint): Any? {
        val productId = joinPoint.args[0] as Long
        logger.info { "Getting product for id $productId" }
        return joinPoint.proceed()
    }

    @Around("execution(* com.codergm.productser.service.impl.ProductServiceImpl.reduceQuantity(..))")
    fun reduceQuantityLogAround(joinPoint: ProceedingJoinPoint): Any? {
        val productId = joinPoint.args[0] as Long
        val quantity = joinPoint.args[1] as Int
        logger.info { "Reducing quantity $quantity for product Id $productId" }
        val result = joinPoint.proceed()
        logger.info { "Product quantity updated successfully" }
        return result
    }

    @Before("execution(* com.codergm.productser.service.impl.ProductServiceImpl.addProduct(..))")
    fun logBeforeAddProduct(){
        logger.info { "Adding product" }
    }

    @AfterReturning(value = "execution(* com.codergm.productser.service.impl.ProductServiceImpl.addProduct(..))", returning = "result")
    fun logAfterAddProduct(result: Any){
        logger.info { "Product with id $result created" }
    }

}