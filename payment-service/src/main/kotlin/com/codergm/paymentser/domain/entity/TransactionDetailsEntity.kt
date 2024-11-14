package com.codergm.paymentser.domain.entity

import jakarta.persistence.*
import org.codergm.ostore.common.model.payment.PaymentMode
import java.time.Instant

@Entity
@Table(name = "transaction_details")
data class TransactionDetailsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val orderId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "MODE")
    val paymentMode: PaymentMode,
    val referenceNumber: String,
    val paymentDate: Instant,
    @Column(name = "status")
    val paymentStatus: String,
    val amount: Double,
)