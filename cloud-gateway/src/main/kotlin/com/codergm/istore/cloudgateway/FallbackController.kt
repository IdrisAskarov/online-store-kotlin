package com.codergm.istore.cloudgateway

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FallbackController {

    @GetMapping("/orderServiceFallBack")
    fun orderFallback(): ResponseEntity<String> {
        return ResponseEntity.ok("Order Service is down!")
    }

    @GetMapping("/paymentServiceFallBack")
    fun paymentFallback(): ResponseEntity<String> {
        return ResponseEntity.ok("Payment Service is down!")
    }

    @GetMapping("/productServiceFallBack")
    fun productFallback(): ResponseEntity<String> {
        return ResponseEntity.ok("Product Service is down!")
    }
}