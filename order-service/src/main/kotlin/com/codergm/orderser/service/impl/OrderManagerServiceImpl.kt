package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.service.OrderManagerService
import com.codergm.orderser.service.OrderService
import com.codergm.orderser.util.toOrderEntity
import jakarta.transaction.Transactional
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class OrderManagerServiceImpl(private val orderService: OrderService) : OrderManagerService {

    private val logger = KotlinLogging.logger {}

    @Transactional
    override fun placeOrder(orderRequest: OrderRequest): Long {
        logger.info { "placing order $orderRequest" }

        val orderEntity = orderService.save(orderRequest.toOrderEntity())

        logger.info { "order placed successfully with orderId ${orderEntity.id}" }

        return orderEntity.id!!
    }
}