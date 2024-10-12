package com.codergm.orderser.service

import com.codergm.orderser.domain.model.OrderRequest

interface OrderManagerService {

    fun placeOrder(orderRequest: OrderRequest): Long
}