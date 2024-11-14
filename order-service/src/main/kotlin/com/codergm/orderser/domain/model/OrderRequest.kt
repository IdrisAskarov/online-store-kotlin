package com.codergm.orderser.domain.model

import org.codergm.ostore.common.model.payment.PaymentMode

data class OrderRequest(
    val id: Long? = null,
    val productId: Long,
    val totalAmount: Double,
    val quantity: Int,
    val paymentMode: PaymentMode
)