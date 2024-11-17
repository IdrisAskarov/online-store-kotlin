package com.codergm.paymentser.repository

import com.codergm.paymentser.domain.entity.TransactionDetailsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionDetailsRepository: JpaRepository<TransactionDetailsEntity, Long>{

    fun findByOrderId(orderId: Long): TransactionDetailsEntity
}