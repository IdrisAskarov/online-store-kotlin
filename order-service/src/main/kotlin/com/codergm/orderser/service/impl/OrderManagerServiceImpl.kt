package com.codergm.orderser.service.impl

import com.codergm.orderser.domain.dto.OrderDto
import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.domain.model.OrderStatus
import com.codergm.orderser.external.client.PaymentService
import com.codergm.orderser.external.client.ProductService
import com.codergm.orderser.service.OrderManagerService
import com.codergm.orderser.service.OrderService
import com.codergm.orderser.util.toOrderDto
import com.codergm.orderser.util.toOrderEntity
import com.codergm.orderser.util.toTransactionDetailsDto
import mu.KotlinLogging
import org.codergm.ostore.common.model.payment.TransactionDetailsDto
import org.codergm.ostore.common.model.product.ProductDto
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OrderManagerServiceImpl(
    private val orderService: OrderService,
    private val productService: ProductService,
    private val paymentService: PaymentService,
    private val restTemplate: RestTemplate
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

    override fun getOrderDetails(orderId: Long): OrderDto {
        val orderEntity = orderService.findOrderById(orderId)

        logger.info { "Invoking Product service to fetch the product for productId: ${orderEntity.productId}" }

        val productDetails = restTemplate.getForObject(
            "http://product-service/product/${orderEntity.productId}",
            ProductDto::class.java
        )

        logger.info { "Getting payment information from the Payment Service" }
        val paymentDetails = restTemplate.getForObject(
            "http://payment-service/payment/${orderEntity.id}",
            TransactionDetailsDto::class.java
        )

        return orderEntity.toOrderDto(productDetails, paymentDetails)
    }
}