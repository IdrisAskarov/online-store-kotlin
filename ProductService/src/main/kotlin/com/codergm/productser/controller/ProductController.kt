package com.codergm.productser.controller

import com.codergm.productser.domain.model.ErrorCode
import com.codergm.productser.domain.model.dto.ProductDto
import com.codergm.productser.exception.ProductNotFoundException

import com.codergm.productser.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import com.codergm.productser.util.toProductDto
import com.codergm.productser.util.toProductEntity

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @PostMapping
    fun addProduct(@RequestBody productDto: ProductDto): ResponseEntity<Long> {
        val productId = productService.addProduct(productDto.toProductEntity())
        return status(HttpStatus.CREATED).body(productId)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable("id") productId: Long): ResponseEntity<ProductDto> {
        val product = productService.getProductById(productId)
        return product?.let { ok(product.toProductDto()) }
            ?: throw ProductNotFoundException(
                ErrorCode.PRODUCT_NOT_FOUND.msg(),
                ErrorCode.PRODUCT_NOT_FOUND
            )
    }


    @PutMapping("/reduce-quantity/{id}")
    fun reduceQuantity(
        @PathVariable("id") productId: Long,
        @RequestParam quantity: Int
    ): ResponseEntity<Unit> {

        productService.reduceQuantity(productId, quantity)
        return ok().build()
    }
}