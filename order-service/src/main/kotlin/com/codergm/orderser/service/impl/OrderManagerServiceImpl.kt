package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.service.OrderManagerService
import com.codergm.orderser.service.OrderService
import com.codergm.orderser.util.toOrderEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderManagerServiceImpl(private val orderService: OrderService) : OrderManagerService {

    @Transactional
    override fun placeOrder(orderRequest: OrderRequest): Long {
        val orderEntity = orderService.save(orderRequest.toOrderEntity())
        return orderEntity.id!!
    }
}