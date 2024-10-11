package com.codergm.productser.config

import com.codergm.productser.domain.ErrorResponse
import com.codergm.productser.domain.ProductErrorCode
import com.codergm.productser.exception.ProductCustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ProductCustomException::class)
    fun productServiceExceptionHandler(exception: ProductCustomException): ResponseEntity<ErrorResponse> {
        val httStatus = when (exception.errorCode) {
            ProductErrorCode.PRODUCT_NOT_FOUND -> HttpStatus.NOT_FOUND
        }
        return ResponseEntity(ErrorResponse(exception.message, exception.errorCode), httStatus)
    }
}