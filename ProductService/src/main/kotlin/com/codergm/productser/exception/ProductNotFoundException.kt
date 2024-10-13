package com.codergm.productser.exception

import com.codergm.productser.domain.model.ErrorCode

class ProductNotFoundException(message: String, val errorCode: ErrorCode): RuntimeException(message)