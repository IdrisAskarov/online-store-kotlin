package com.codergm.orderser.domain.entity

import com.codergm.orderser.domain.model.OrderStatus
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "order_details")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    val productId: Long,

    val quantity: Int,

    val orderDate: Instant,

    @Enumerated(EnumType.STRING)
    var orderStatus: OrderStatus,

    val amount: Double
)