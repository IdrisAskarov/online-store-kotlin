package com.codergm.productser.service.impl

import com.codergm.productser.domain.entity.ProductEntity
import com.codergm.productser.repository.ProductRepository
import com.codergm.productser.service.ProductService
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    private val logger = KotlinLogging.logger {}

    override fun addProduct(productEntity: ProductEntity): Long {
        logger.info { "Adding product $productEntity" }

        productRepository.save(productEntity)

        val productId = productEntity.productId ?: throw Exception("Product wasn't created")

        logger.info { "Product $productId created" }
        return productId
    }

    override fun getProductById(productId: Long): ProductEntity? {
        logger.info { "Getting product for $productId" }
        val product = productRepository.findByIdOrNull(productId)

        return product
    }
}