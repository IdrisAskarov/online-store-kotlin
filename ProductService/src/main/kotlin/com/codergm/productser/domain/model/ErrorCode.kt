package com.codergm.productser.domain.model

enum class ErrorCode {
    PRODUCT_NOT_FOUND{
        override fun msg() = "Product not found"
    },
    PRODUCT_NOT_CREATED{
        override fun msg() = "Product could not be created"
    },
    PRODUCT_INSUFFICIENT{
        override fun msg() = "Product stock is insufficient."
    },
    PRODUCT_UNPREDICTED{
        override fun msg() = "Unpredicted error"
    };

    abstract fun msg(): String
}