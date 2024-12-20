package com.codergm.productser.config

import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.product.ProductErrorCode
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
            ProductErrorResponse(
                exception.message!!,
                exception.errorCode,
                exception.httpStatusCode ?: HttpStatus.INTERNAL_SERVER_ERROR.value()
            ),
            HttpStatus.valueOf(exception.httpStatusCode ?: HttpStatus.INTERNAL_SERVER_ERROR.value())
        )
    }


    @ExceptionHandler(IllegalStateException::class)
    fun illegalStateExceptionHandler(exception: IllegalStateException): ResponseEntity<ProductErrorResponse> {
        return when (exception.message) {
            ProductErrorCode.PRODUCT_NOT_FOUND.name -> ResponseEntity(
                ProductErrorResponse(
                    ProductErrorCode.PRODUCT_NOT_FOUND.msg(),
                    ProductErrorCode.PRODUCT_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()
                ), HttpStatus.NOT_FOUND
            )

            else -> badRequest().body(
                ProductErrorResponse(
                    exception.message!!,
                    ProductErrorCode.PRODUCT_UNPREDICTED_ERROR,
                    HttpStatus.BAD_REQUEST.value()
                )
            )
        }
    }
}