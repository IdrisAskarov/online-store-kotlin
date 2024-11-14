package com.codergm.orderser.exception

import org.codergm.ostore.common.model.order.OrderErrorCode


class OrderPlacingException(message: String, val errorCode: OrderErrorCode, val httpStatusCode: Int?): RuntimeException(message) {
}