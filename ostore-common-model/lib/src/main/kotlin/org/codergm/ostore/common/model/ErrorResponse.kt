package org.codergm.ostore.common.model

data class ErrorResponse(
    val errorMessage: String = ErrorCode.PRODUCT_UNPREDICTED.msg(),
    val errorCode: ErrorCode = ErrorCode.PRODUCT_UNPREDICTED,
    val httpStatusCode: Int = 500
)