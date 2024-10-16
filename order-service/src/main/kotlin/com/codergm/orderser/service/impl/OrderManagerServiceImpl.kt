package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.external.client.ProductService
import com.codergm.orderser.service.OrderManagerService
import com.codergm.orderser.service.OrderService
import com.codergm.orderser.util.toOrderEntity
import org.springframework.stereotype.Service

@Service
class OrderManagerServiceImpl(
    private val orderService: OrderService,
    private val productService: ProductService
) : OrderManagerService {

    override fun placeOrder(orderRequest: OrderRequest): Long {

        productService.reduceQuantity(orderRequest.productId, orderRequest.quantity)

        val orderEntity = orderService.save(orderRequest.toOrderEntity())
        return orderEntity.id!!
    }
}