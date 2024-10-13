package com.codergm.productser.service.impl

import com.codergm.productser.domain.model.ErrorCode
import com.codergm.productser.domain.entity.ProductEntity
import com.codergm.productser.repository.ProductRepository
import com.codergm.productser.service.ProductService
import com.codergm.productser.util.*
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun addProduct(productEntity: ProductEntity): Long {
        productRepository.save(productEntity)
        val productId = productEntity.nonNullId()
        return productId
    }

    override fun getProductById(productId: Long): ProductEntity? = productRepository.findByIdOrNull(productId)

    override fun reduceQuantity(productId: Long, quantity: Int) {
        val product = productRepository.findByIdOrNull(productId)

        checkNotNull(product) { ErrorCode.PRODUCT_NOT_FOUND }
        product.checkSufficientQuantity(quantity)
        product.reduceQuantity(quantity)

        productRepository.save(product)
    }
}