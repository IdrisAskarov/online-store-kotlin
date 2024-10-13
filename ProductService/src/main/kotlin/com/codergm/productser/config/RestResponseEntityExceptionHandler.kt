package com.codergm.productser.config

import com.codergm.productser.domain.model.ErrorCode
import com.codergm.productser.domain.model.ErrorResponse
import com.codergm.productser.exception.ProductCreationException
import com.codergm.productser.exception.ProductInsufficientQuantityException

import com.codergm.productser.exception.ProductNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ProductNotFoundException::class)
    fun productNotFoundExceptionHandler(exception: ProductNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(exception.message, exception.errorCode), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ProductCreationException::class)
    fun productCreationExceptionHandler(exception: ProductCreationException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(exception.message, exception.errorCode), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ProductInsufficientQuantityException::class)
    fun productInsufficientQuantityExceptionHandler(exception: ProductInsufficientQuantityException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(exception.message, exception.errorCode), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalStateException::class)
    fun illegalStateExceptionHandler(exception: IllegalStateException): ResponseEntity<ErrorResponse> {
        return when (exception.message) {
            ErrorCode.PRODUCT_NOT_FOUND.name -> ResponseEntity(
                ErrorResponse(
                    ErrorCode.PRODUCT_NOT_FOUND.msg(),
                    ErrorCode.PRODUCT_NOT_FOUND
                ), HttpStatus.BAD_REQUEST
            )

            else -> ResponseEntity(
                ErrorResponse(exception.message, ErrorCode.PRODUCT_UNPREDICTED),
                HttpStatus.BAD_REQUEST
            )
        }
    }
}