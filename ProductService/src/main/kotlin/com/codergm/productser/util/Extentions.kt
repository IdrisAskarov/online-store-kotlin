package com.codergm.productser.util

import com.codergm.productser.domain.model.dto.ProductDto
import com.codergm.productser.domain.entity.ProductEntity
import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.ErrorCode
import org.springframework.http.HttpStatus

fun ProductDto.toProductEntity() = ProductEntity(
    productId = this.productId,
    productName = this.productName,
    price = this.price,
    quantity = quantity
)

fun ProductEntity.toProductDto() = ProductDto(
    productId = this.productId,
    productName = this.productName,
    price = this.price,
    quantity = quantity
)

fun ProductEntity.checkSufficientQuantity(quantity: Int) {
    if (this.quantity < quantity) throw ProductException(
        ErrorCode.PRODUCT_INSUFFICIENT_QUANTITY.msg(),
        ErrorCode.PRODUCT_INSUFFICIENT_QUANTITY,
        HttpStatus.BAD_REQUEST.value()
    )
}

fun ProductEntity.reduceQuantity(quantity: Int) {
    this.quantity -= quantity
}

fun ProductEntity.nonNullId(): Long {
    return this.productId ?: throw ProductException(
        ErrorCode.PRODUCT_NOT_CREATED.msg(),
        ErrorCode.PRODUCT_NOT_CREATED,
        HttpStatus.NOT_FOUND.value()
    )
}