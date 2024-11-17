package org.codergm.ostore.common.model.payment

import java.time.Instant

data class TransactionDetailsDto(
    val paymentId: Long?,
    val orderId: Long,
    val amount: Double,
    val referenceNumber: String,
    val paymentMode: PaymentMode,
    val paymentDate: Instant?,
    val paymentStatus: String?
)