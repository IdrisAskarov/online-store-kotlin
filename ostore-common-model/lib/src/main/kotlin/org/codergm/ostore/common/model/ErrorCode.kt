package org.codergm.ostore.common.model

enum class ErrorCode {
    PRODUCT_NOT_FOUND{
        override fun msg() = "Product not found"
    },
    PRODUCT_NOT_CREATED{
        override fun msg() = "Product could not be created"
    },
    PRODUCT_INSUFFICIENT_QUANTITY{
        override fun msg() = "Product stock is insufficient."
    },
    PRODUCT_UNPREDICTED{
        override fun msg() = "Unpredicted error"
    },
    ORDER_NOT_PLACED{
        override fun msg() = "Failed to place order"
    };


    abstract fun msg(): String
}