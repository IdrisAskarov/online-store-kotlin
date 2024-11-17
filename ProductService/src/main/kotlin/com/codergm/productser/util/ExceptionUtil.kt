package com.codergm.productser.util

import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.product.ProductErrorCode
import org.springframework.http.HttpStatus

fun createProductNotFoundException() = ProductException(
    ProductErrorCode.PRODUCT_NOT_FOUND.msg(),
    ProductErrorCode.PRODUCT_NOT_FOUND,
    HttpStatus.NOT_FOUND.value()
)