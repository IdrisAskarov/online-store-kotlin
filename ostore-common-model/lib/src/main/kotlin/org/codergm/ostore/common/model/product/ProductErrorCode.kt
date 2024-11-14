package org.codergm.ostore.common.model.product

enum class ProductErrorCode {
    PRODUCT_NOT_FOUND{
        override fun msg() = "Product not found"
    },
    PRODUCT_NOT_CREATED{
        override fun msg() = "Product could not be created"
    },
    PRODUCT_INSUFFICIENT_QUANTITY{
        override fun msg() = "Product stock is insufficient."
    },
    PRODUCT_UNPREDICTED_ERROR{
        override fun msg() = "Unpredicted product error"
    };
    abstract fun msg(): String
}