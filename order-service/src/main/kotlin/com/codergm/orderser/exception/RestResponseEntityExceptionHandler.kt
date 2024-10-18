package com.codergm.orderser.exception

import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.ErrorResponse

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ProductException::class)
    fun productExceptionHandler(exception: ProductException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(exception.message!!, exception.errorCode, exception.httpStatusCode!!),
            HttpStatus.valueOf(exception.httpStatusCode ?: HttpStatus.INTERNAL_SERVER_ERROR.value())
        )
    }

    @ExceptionHandler(OrderPlacingException::class)
    fun orderPlacingExceptionHandler(exception: OrderPlacingException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(exception.message!!, exception.errorCode, exception.httpStatusCode!!),
            HttpStatus.valueOf(exception.httpStatusCode)
        )
    }
}