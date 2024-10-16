package com.codergm.orderser.external.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "PRODUCT-SERVICE/product")
interface ProductService {
    
    @PutMapping("/reduce-quantity/{id}")
    fun reduceQuantity(@PathVariable("id") productId: Long, @RequestParam quantity: Int): ResponseEntity<Unit>
}