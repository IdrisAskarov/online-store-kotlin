package com.codergm.orderser.controller

import com.codergm.orderser.service.OrderService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(private val orderService: OrderService) {
    private val logger = KotlinLogging.logger {}
}