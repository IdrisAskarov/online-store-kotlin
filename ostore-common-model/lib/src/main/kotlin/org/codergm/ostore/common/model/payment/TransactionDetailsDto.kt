package org.codergm.ostore.common.model.payment

import org.codergm.ostore.common.model.PaymentMode

data class TransactionDetailsDto(
    val orderId: Long,
    val amount: Double,
    val referenceNumber: String,
    val paymentMode: PaymentMode
)