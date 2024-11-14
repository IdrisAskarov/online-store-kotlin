package org.codergm.ostore.common.model.payment

data class TransactionDetailsDto(
    val orderId: Long,
    val amount: Double,
    val referenceNumber: String,
    val paymentMode: PaymentMode
)