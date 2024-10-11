package com.codergm.productser.domain.dto


data class ProductDto(
    val productId: Long?,
    val productName: String,
    val price: Double,
    val quantity: Int
)