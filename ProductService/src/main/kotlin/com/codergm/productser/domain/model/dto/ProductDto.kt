package com.codergm.productser.domain.model.dto


data class ProductDto(
    val productId: Long?,
    val productName: String,
    val price: Double,
    val quantity: Int
)