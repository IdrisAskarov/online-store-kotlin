package com.codergm.orderser.domain.entity

import com.codergm.orderser.domain.OrderStatus
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "order_details")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val productId: Long,
    val quantity: Long,
    val orderDate: Instant,
    val orderStatus: OrderStatus,
    val amount: Double
)