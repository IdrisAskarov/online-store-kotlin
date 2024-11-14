package com.codergm.paymentser.service.impl

import com.codergm.paymentser.domain.entity.TransactionDetailsEntity
import com.codergm.paymentser.repository.TransactionDetailsRepository
import com.codergm.paymentser.service.PaymentService
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl(private val transactionDetailsRepository: TransactionDetailsRepository) : PaymentService {

    override fun doPayment(transactionDetailsEntity:  TransactionDetailsEntity): Long? {
        transactionDetailsRepository.save(transactionDetailsEntity)
        return transactionDetailsEntity.id
    }
}