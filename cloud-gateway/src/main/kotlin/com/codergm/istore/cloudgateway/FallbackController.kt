package com.codergm.istore.cloudgateway

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FallbackController {
    @GetMapping("/fallback")
    fun fallback(): ResponseEntity<String> {
        return ResponseEntity.ok("Fallback triggered!")
    }
}