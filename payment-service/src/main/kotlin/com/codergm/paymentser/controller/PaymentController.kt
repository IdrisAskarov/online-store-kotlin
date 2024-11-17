package com.codergm.paymentser.controller

import com.codergm.paymentser.service.PaymentService
import com.codergm.paymentser.util.toTransactionDetailsDto
import com.codergm.paymentser.util.toTransactionDetailsEntity
import org.codergm.ostore.common.model.payment.TransactionDetailsDto
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/payment")
class PaymentController(private val paymentService: PaymentService) {

    @PostMapping("")
    fun doPayment(@RequestBody transactionDetailsDto: TransactionDetailsDto): ResponseEntity<Long> {
        return ok(paymentService.doPayment(transactionDetailsDto.toTransactionDetailsEntity()))
    }

    @GetMapping("/{orderId}")
    fun getOrderPaymentDetails(@PathVariable orderId: Long): ResponseEntity<TransactionDetailsDto> {
        return ok().body(paymentService.getOrderPaymentDetails(orderId).toTransactionDetailsDto())
    }
}