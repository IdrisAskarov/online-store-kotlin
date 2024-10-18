package org.codergm.ostore.common.exception.product

import org.codergm.ostore.common.model.ErrorCode

class ProductException(message: String, val errorCode: ErrorCode, val httpStatusCode: Int?): RuntimeException(message)