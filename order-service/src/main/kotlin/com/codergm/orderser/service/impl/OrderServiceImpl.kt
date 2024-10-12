package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.entity.OrderEntity
import com.codergm.orderser.repository.OrderRepository
import com.codergm.orderser.service.OrderService
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(private val orderRepository: OrderRepository): OrderService {

    private val logger = KotlinLogging.logger {}

    override fun save(order: OrderEntity): OrderEntity {

        logger.info { "Saving order: $order" }

        return orderRepository.save(order)
    }

}