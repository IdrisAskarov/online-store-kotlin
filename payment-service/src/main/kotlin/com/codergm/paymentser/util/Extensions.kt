package com.codergm.paymentser.util

import com.codergm.paymentser.domain.entity.TransactionDetailsEntity
import com.codergm.paymentser.domain.model.TransactionDetailsDto
import java.time.Instant

fun TransactionDetailsDto.toTransactionDetailsEntity() = TransactionDetailsEntity(
    id = null,
    orderId = this.orderId,
    amount = this.amount,
    paymentMode = this.paymentMode,
    referenceNumber = this.referenceNumber,
    paymentDate = Instant.now(),
    paymentStatus = "SUCCESS"
)