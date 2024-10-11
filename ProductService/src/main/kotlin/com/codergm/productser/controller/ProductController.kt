package com.codergm.productser.controller

import com.codergm.productser.domain.ProductErrorCode
import com.codergm.productser.domain.dto.ProductDto
import com.codergm.productser.exception.ProductCustomException
import com.codergm.productser.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import util.toProductDto
import util.toProductEntity

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
            ?: throw ProductCustomException(
                "Product with given id: $productId not found",
                ProductErrorCode.PRODUCT_NOT_FOUND
            )
    }
}