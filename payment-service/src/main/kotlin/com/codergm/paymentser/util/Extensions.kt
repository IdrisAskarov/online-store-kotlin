package com.codergm.paymentser.util

import com.codergm.paymentser.domain.entity.TransactionDetailsEntity
import org.codergm.ostore.common.model.payment.TransactionDetailsDto

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

fun TransactionDetailsEntity.toTransactionDetailsDto() = TransactionDetailsDto(
    paymentId = this.id,
    orderId = this.orderId,
    amount = this.amount,
    paymentMode = this.paymentMode,
    referenceNumber = this.referenceNumber,
    paymentDate = this.paymentDate,
    paymentStatus = this.paymentStatus
)