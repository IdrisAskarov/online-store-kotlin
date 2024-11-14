package com.codergm.paymentser.domain.entity

import jakarta.persistence.*
import org.codergm.ostore.common.model.PaymentMode
import java.time.Instant

@Entity
@Table(name = "transaction_details")
data class TransactionDetailsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val orderId: Long,

    @Enumerated(EnumType.STRING)
    @Column(
        name = "MODE",
        columnDefinition = "VARCHAR(20) CHECK (MODE IN ('CASH', 'PAYPAL', 'DEBIT_CARD', 'CREDIT_CARD', 'APPLE_PAY'))"
    )
    val paymentMode: PaymentMode,
    val referenceNumber: String,
    val paymentDate: Instant,
    @Column(name = "status")
    val paymentStatus: String,
    val amount: Double,
)