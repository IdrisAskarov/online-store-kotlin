package org.codergm.ostore.common.model.order

enum class OrderErrorCode {
    ORDER_NOT_FOUND{
        override fun msg() = "Order not found"
    },
    ORDER_NOT_PLACED{
        override fun msg() = "Failed to place order"
    },
    ORDER_UNPREDICTED_ERROR{
        override fun msg() = "Unpredicted order error"
    };


    abstract fun msg(): String
}