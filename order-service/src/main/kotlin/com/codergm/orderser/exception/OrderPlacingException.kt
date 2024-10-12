package com.codergm.orderser.exception

import com.codergm.orderser.domain.model.ErrorCode

class OrderPlacingException(message: String, val errorCode: ErrorCode): Exception(message) {
}