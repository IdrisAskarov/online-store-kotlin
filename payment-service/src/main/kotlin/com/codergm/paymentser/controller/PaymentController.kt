package com.codergm.paymentser.controller

import com.codergm.paymentser.service.PaymentService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment")
class PaymentController(val paymentService: PaymentService) {

}