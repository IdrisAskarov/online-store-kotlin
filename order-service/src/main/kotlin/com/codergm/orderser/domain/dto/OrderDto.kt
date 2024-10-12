package com.codergm.orderser.domain.dto

import com.codergm.orderser.domain.model.OrderStatus
import java.time.Instant

data class OrderDto(val id: Long?,
                    val productId: Long,
                    val quantity: Long,
                    val orderDate: Instant,
                    val orderStatus: OrderStatus,
                    val amount: Double)