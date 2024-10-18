package com.codergm.orderser.exception

import org.codergm.ostore.common.model.ErrorCode

class OrderPlacingException(message: String, val errorCode: ErrorCode, val httpStatusCode: Int?): RuntimeException(message) {
}