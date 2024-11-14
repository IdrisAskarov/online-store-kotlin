package com.codergm.orderser.config

import com.codergm.orderser.exception.OrderPlacingException
import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.order.OrderErrorCode
import org.codergm.ostore.common.model.order.OrderErrorResponse
import org.codergm.ostore.common.model.product.ProductErrorResponse

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.badRequest
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ProductException::class)
    fun productExceptionHandler(exception: ProductException): ResponseEntity<ProductErrorResponse> {
        return ResponseEntity(
            ProductErrorResponse(exception.message!!, exception.errorCode, exception.httpStatusCode!!),
            HttpStatus.valueOf(exception.httpStatusCode ?: HttpStatus.INTERNAL_SERVER_ERROR.value())
        )
    }

    @ExceptionHandler(OrderPlacingException::class)
    fun orderPlacingExceptionHandler(exception: OrderPlacingException): ResponseEntity<OrderErrorResponse> {
        return ResponseEntity(
            OrderErrorResponse(exception.message!!, exception.errorCode, exception.httpStatusCode!!),
            HttpStatus.valueOf(exception.httpStatusCode)
        )
    }

    @ExceptionHandler(IllegalStateException::class)
    fun illegalStateExceptionHandler(exception: IllegalStateException): ResponseEntity<OrderErrorResponse> {
        return when (exception.message) {
            OrderErrorCode.ORDER_NOT_FOUND.name -> ResponseEntity(
                OrderErrorResponse(
                    OrderErrorCode.ORDER_NOT_FOUND.name,
                    OrderErrorCode.ORDER_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()
                ), HttpStatus.NOT_FOUND
            )

            else -> badRequest().body(
                OrderErrorResponse(
                    OrderErrorCode.ORDER_UNPREDICTED_ERROR.msg(),
                    OrderErrorCode.ORDER_UNPREDICTED_ERROR,
                    HttpStatus.BAD_REQUEST.value()
                )
            )
        }
    }
}