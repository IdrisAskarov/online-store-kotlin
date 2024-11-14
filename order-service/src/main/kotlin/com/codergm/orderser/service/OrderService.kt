package com.codergm.orderser.service

import com.codergm.orderser.domain.entity.OrderEntity

interface OrderService {

    fun save(order: OrderEntity): OrderEntity

    fun getOrderDetails(orderId: Long): OrderEntity
}