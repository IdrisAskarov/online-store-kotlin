package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.entity.OrderEntity
import com.codergm.orderser.repository.OrderRepository
import com.codergm.orderser.service.OrderService
import org.codergm.ostore.common.model.order.OrderErrorCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(private val orderRepository: OrderRepository): OrderService {

    override fun save(order: OrderEntity): OrderEntity {
        return orderRepository.save(order)
    }

    override fun findOrderById(orderId: Long): OrderEntity {
        val orderEntity = orderRepository.findByIdOrNull(orderId)

        checkNotNull(orderEntity) { OrderErrorCode.ORDER_NOT_FOUND }

        return orderEntity
    }

}