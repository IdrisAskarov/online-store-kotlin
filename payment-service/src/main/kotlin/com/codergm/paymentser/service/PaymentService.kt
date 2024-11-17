package com.codergm.paymentser.service

import com.codergm.paymentser.domain.entity.TransactionDetailsEntity

interface PaymentService {
    fun doPayment(transactionDetailsEntity: TransactionDetailsEntity): Long?
    fun getOrderPaymentDetails(orderId: Long): TransactionDetailsEntity
}