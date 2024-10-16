package com.codergm.productser.util

import com.codergm.productser.domain.model.dto.ProductDto
import com.codergm.productser.domain.entity.ProductEntity
import com.codergm.productser.domain.model.ErrorCode
import com.codergm.productser.exception.ProductCreationException
import com.codergm.productser.exception.ProductInsufficientQuantityException

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
    if (this.quantity < quantity) throw ProductInsufficientQuantityException(
        ErrorCode.PRODUCT_INSUFFICIENT_QUANTITY.msg(),
        ErrorCode.PRODUCT_INSUFFICIENT_QUANTITY
    )
}

fun ProductEntity.reduceQuantity(quantity: Int) {
    this.quantity -= quantity
}

fun ProductEntity.nonNullId(): Long {
    return this.productId ?: throw ProductCreationException(
        ErrorCode.PRODUCT_NOT_CREATED.msg(),
        ErrorCode.PRODUCT_NOT_CREATED
    )
}