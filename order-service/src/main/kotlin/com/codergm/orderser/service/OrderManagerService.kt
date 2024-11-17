package com.codergm.orderser.service

import com.codergm.orderser.domain.dto.OrderDto
import com.codergm.orderser.domain.model.OrderRequest

interface OrderManagerService {

    fun placeOrder(orderRequest: OrderRequest): Long

    fun getOrderDetails(orderId: Long): OrderDto
}