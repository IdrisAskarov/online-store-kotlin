package com.codergm.orderser.domain.dto

import com.codergm.orderser.domain.model.OrderStatus
import org.codergm.ostore.common.model.payment.TransactionDetailsDto
import org.codergm.ostore.common.model.product.ProductDto
import java.time.Instant

data class OrderDto(
    val id: Long?,
    val productId: Long,
    val quantity: Int,
    val orderDate: Instant,
    val orderStatus: OrderStatus,
    val amount: Double,
    val productDetails: ProductDto?,
    val paymentDetails: TransactionDetailsDto?
)