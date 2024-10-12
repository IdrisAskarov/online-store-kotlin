package com.codergm.orderser.controller

import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.service.OrderManagerService

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(private val orderManagerService: OrderManagerService) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/place-order")
    fun placeOrder(@RequestBody orderRequest: OrderRequest): ResponseEntity<Long>{
        val orderId = orderManagerService.placeOrder(orderRequest)
        logger.info { "Order Id: $orderId" }
        return ok(orderId)
    }
}