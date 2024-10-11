package com.codergm.productser.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val productId: Long?,
    val productName: String,
    val price: Double,
    val quantity: Int
)