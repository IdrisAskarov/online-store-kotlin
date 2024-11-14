package com.codergm.orderser.external.client

import org.codergm.ostore.common.model.payment.TransactionDetailsDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "payment-service/payment")
interface PaymentService {
    
    @PostMapping("")
    fun doPayment(@RequestBody transactionDetailsDto: TransactionDetailsDto): ResponseEntity<Long>
}