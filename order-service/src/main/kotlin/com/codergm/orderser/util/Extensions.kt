package com.codergm.orderser.util

import com.codergm.orderser.domain.entity.OrderEntity
import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.domain.model.OrderStatus
import java.time.Instant

fun OrderRequest.toOrderEntity() = OrderEntity(
    id = this?.id,
    productId = this.productId,
    amount = this.totalAmount,
    quantity = this.quantity,
    orderStatus = OrderStatus.CREATED,
    orderDate = Instant.now()
)