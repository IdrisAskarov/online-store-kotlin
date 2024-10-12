package com.codergm.productser.util

import com.codergm.productser.domain.dto.ProductDto
import com.codergm.productser.domain.entity.ProductEntity

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