package com.codergm.productser.config

import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.ErrorCode
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
            ErrorResponse(
                exception.message!!,
                exception.errorCode,
                exception.httpStatusCode ?: HttpStatus.INTERNAL_SERVER_ERROR.value()
            ),
            HttpStatus.valueOf(exception.httpStatusCode ?: HttpStatus.INTERNAL_SERVER_ERROR.value())
        )
    }


    @ExceptionHandler(IllegalStateException::class)
    fun illegalStateExceptionHandler(exception: IllegalStateException): ResponseEntity<ErrorResponse> {
        return when (exception.message) {
            ErrorCode.PRODUCT_NOT_FOUND.name -> ResponseEntity(
                ErrorResponse(
                    ErrorCode.PRODUCT_NOT_FOUND.msg(),
                    ErrorCode.PRODUCT_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()
                ), HttpStatus.BAD_REQUEST
            )

            else -> ResponseEntity(
                ErrorResponse(
                    exception.message!!,
                    ErrorCode.PRODUCT_UNPREDICTED,
                    HttpStatus.BAD_REQUEST.value()
                ),
                HttpStatus.BAD_REQUEST
            )
        }
    }
}