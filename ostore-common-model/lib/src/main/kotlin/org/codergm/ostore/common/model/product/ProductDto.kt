package org.codergm.ostore.common.model.product

data class ProductDto(
    val productId: Long?,
    val productName: String,
    val price: Double,
    val quantity: Int
)