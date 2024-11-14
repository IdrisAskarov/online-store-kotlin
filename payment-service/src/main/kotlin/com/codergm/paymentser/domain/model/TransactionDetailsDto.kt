package com.codergm.paymentser.domain.model

data class TransactionDetailsDto(
    val orderId: Long,
    val amount: Double,
    val referenceNumber: String,
    val paymentMode: PaymentMode
)