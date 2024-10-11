package com.codergm.productser.exception

import com.codergm.productser.domain.ProductErrorCode

class ProductCustomException(message: String,val errorCode: ProductErrorCode): RuntimeException(message) {

}