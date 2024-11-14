package com.codergm.orderser.controller

import com.codergm.orderser.domain.dto.OrderDto
import com.codergm.orderser.domain.model.OrderRequest
import com.codergm.orderser.service.OrderManagerService
import com.codergm.orderser.service.OrderService
import com.codergm.orderser.util.toOrderDto
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController(
    private val orderManagerService: OrderManagerService,
    private val orderService: OrderService
) {

    @PostMapping("/place-order")
    fun placeOrder(@RequestBody orderRequest: OrderRequest): ResponseEntity<Long> {
        val orderId = orderManagerService.placeOrder(orderRequest)
        return ok(orderId)
    }

    @GetMapping("/{orderId}")
    fun getOrderDetails(@PathVariable orderId: Long): ResponseEntity<OrderDto> {
        val orderEntity = orderService.getOrderDetails(orderId)
        return ok(orderEntity.toOrderDto())
    }
}