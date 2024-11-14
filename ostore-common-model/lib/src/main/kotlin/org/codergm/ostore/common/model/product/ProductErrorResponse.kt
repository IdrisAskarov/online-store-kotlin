package org.codergm.ostore.common.model.product

import org.codergm.ostore.common.model.ErrorCode

data class ProductErrorResponse(
    val errorMessage: String = ErrorCode.PRODUCT_UNPREDICTED.msg(),
    val errorCode: ProductErrorCode = ProductErrorCode.PRODUCT_UNPREDICTED_ERROR,
    val httpStatusCode: Int = 500
)