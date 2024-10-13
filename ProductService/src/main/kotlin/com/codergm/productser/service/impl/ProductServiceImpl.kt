package com.codergm.productser.service.impl

import com.codergm.productser.domain.model.ErrorCode
import com.codergm.productser.domain.entity.ProductEntity
import com.codergm.productser.exception.ProductCreationException
import com.codergm.productser.repository.ProductRepository
import com.codergm.productser.service.ProductService
import com.codergm.productser.util.*
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    private val logger = KotlinLogging.logger {}

    override fun addProduct(productEntity: ProductEntity): Long {
        logger.info { "Adding product $productEntity" }

        productRepository.save(productEntity)

        val productId = productEntity.productId ?: throw ProductCreationException(
            ErrorCode.PRODUCT_NOT_CREATED.msg(),
            ErrorCode.PRODUCT_NOT_CREATED
        )

        logger.info { "Product $productId created" }
        return productId
    }

    override fun getProductById(productId: Long): ProductEntity? {
        logger.info { "Getting product for $productId" }
        val product = productRepository.findByIdOrNull(productId)

        return product
    }

    override fun reduceQuantity(productId: Long, quantity: Int) {
        logger.info { "Reducing quantity $quantity for product Id $productId" }

        val product = productRepository.findByIdOrNull(productId)

        checkNotNull(product) { ErrorCode.PRODUCT_NOT_FOUND }

        product.checkSufficientQuantity(quantity)

        product.decreaseQuantity(quantity)

        productRepository.save(product)

        logger.info { "Product quantity updated successfully" }

    }
}