package com.codergm.paymentser.domain.entity

import com.codergm.paymentser.domain.model.PaymentMode
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "transaction_details")
data class TransactionDetailsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val orderId: Long,
    @Column(name = "MODE")
    val paymentMode: PaymentMode,
    val referenceNumber: String,
    val paymentDate: Instant,
    @Column(name = "status")
    val paymentStatus: String,
    val amount: Double,
)