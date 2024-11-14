package org.codergm.ostore.common.exception.product

import org.codergm.ostore.common.model.product.ProductErrorCode


class ProductException(message: String, val errorCode: ProductErrorCode, val httpStatusCode: Int?): RuntimeException(message)