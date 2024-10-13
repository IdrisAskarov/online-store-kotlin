package com.codergm.productser.service

import com.codergm.productser.domain.entity.ProductEntity

interface ProductService {
    fun addProduct(productEntity: ProductEntity): Long
    fun getProductById(productId: Long): ProductEntity?
    fun reduceQuantity(productId: Long, quantity: Int)
}