package com.codergm.orderser.util

import com.codergm.orderser.domain.dto.OrderDto
import com.codergm.orderser.domain.entity.OrderEntity
import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.domain.model.OrderStatus
import org.codergm.ostore.common.model.payment.TransactionDetailsDto
import org.codergm.ostore.common.model.product.ProductDto
import java.time.Instant

fun OrderRequest.toOrderEntity() = OrderEntity(
    id = this.id,
    productId = this.productId,
    amount = this.totalAmount,
    quantity = this.quantity,
    orderStatus = OrderStatus.CREATED,
    orderDate = Instant.now()
)

fun OrderRequest.toTransactionDetailsDto(orderId: Long) = TransactionDetailsDto(
    orderId = orderId,
    amount = this.totalAmount,
    paymentMode = this.paymentMode,
    referenceNumber = "",
    paymentId = null,
    paymentDate = null,
    paymentStatus = null


)

fun OrderEntity.toOrderDto(productDto: ProductDto?, paymentDetails: TransactionDetailsDto?) = OrderDto(
    id = this.id,
    productId = this.productId,
    amount = this.amount,
    orderDate = this.orderDate,
    orderStatus = this.orderStatus,
    quantity = this.quantity,
    productDetails = productDto,
    paymentDetails = paymentDetails
)