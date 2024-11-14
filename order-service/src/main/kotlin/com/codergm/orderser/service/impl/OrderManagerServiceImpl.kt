package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.domain.model.OrderStatus
import com.codergm.orderser.external.client.PaymentService
import com.codergm.orderser.external.client.ProductService
import com.codergm.orderser.repository.OrderRepository
import com.codergm.orderser.service.OrderManagerService
import com.codergm.orderser.service.OrderService
import com.codergm.orderser.util.toOrderEntity
import com.codergm.orderser.util.toTransactionDetailsDto
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class OrderManagerServiceImpl(
    private val orderService: OrderService,
    private val productService: ProductService,
    private val paymentService: PaymentService,
) : OrderManagerService {
    val logger = KotlinLogging.logger { this::class.qualifiedName }
    override fun placeOrder(orderRequest: OrderRequest): Long {

        productService.reduceQuantity(orderRequest.productId, orderRequest.quantity)

        val orderEntity = orderService.save(orderRequest.toOrderEntity())
        logger.info { "Calling Payment Service to complete the payment" }
        try {
            paymentService.doPayment(orderRequest.toTransactionDetailsDto(orderEntity.id!!))
            logger.info { "Payment done successfully. Changing the order status to PLACED " }
            orderEntity.orderStatus = OrderStatus.PLACED
        } catch (e: Exception) {
            logger.error(e) { "Error while calling Payment Service to complete the payment" }
            orderEntity.orderStatus = OrderStatus.PAYMENT_FAILED
        }

        orderService.save(orderEntity)

        return orderEntity.id!!
    }
}