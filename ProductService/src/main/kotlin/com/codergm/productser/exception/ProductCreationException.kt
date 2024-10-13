package com.codergm.productser.exception

import com.codergm.productser.domain.model.ErrorCode

class ProductCreationException(message: String, val errorCode: ErrorCode): RuntimeException(message)