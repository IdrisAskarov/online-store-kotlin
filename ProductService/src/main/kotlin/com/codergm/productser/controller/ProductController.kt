package com.codergm.productser.controller


import com.codergm.productser.service.ProductService
import com.codergm.productser.util.createProductNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import com.codergm.productser.util.toProductDto
import com.codergm.productser.util.toProductEntity
import org.codergm.ostore.common.model.product.ProductDto


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
        val product = productService.getProductById(productId) ?: throw createProductNotFoundException()
        return ok(product.toProductDto())
    }


    @PutMapping("/reduce-quantity/{id}")
    fun reduceQuantity(@PathVariable("id") productId: Long, @RequestParam quantity: Int): ResponseEntity<Unit> {
        productService.reduceQuantity(productId, quantity)
        return ok().build()
    }
}