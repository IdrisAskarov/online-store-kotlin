package org.codergm.ostore.common.model.order

import org.codergm.ostore.common.model.ErrorCode

data class OrderErrorResponse(
    val errorMessage: String = ErrorCode.PRODUCT_UNPREDICTED.msg(),
    val errorCode: OrderErrorCode = OrderErrorCode.ORDER_UNPREDICTED_ERROR,
    val httpStatusCode: Int = 500
)