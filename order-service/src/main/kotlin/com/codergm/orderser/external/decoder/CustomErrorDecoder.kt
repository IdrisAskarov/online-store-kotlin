package com.codergm.orderser.external.decoder


import com.codergm.orderser.exception.OrderPlacingException
import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.ErrorDecoder
import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.order.OrderErrorCode
import org.codergm.ostore.common.model.product.ProductErrorResponse

import org.springframework.http.HttpStatus

open class CustomErrorDecoder : ErrorDecoder {

    override fun decode(s: String?, response: Response?): Exception {
        return try {
            val body = response?.body()?.asInputStream()?.bufferedReader().use { it?.readText() }
            val objectMapper = ObjectMapper()
            val productErrorResponse: ProductErrorResponse = objectMapper.readValue(body, ProductErrorResponse::class.java)

            ProductException(
                productErrorResponse.errorMessage,
                productErrorResponse.errorCode,
                productErrorResponse.httpStatusCode
            )
        } catch (e: Exception) {
            OrderPlacingException(
                e.message!!,
                OrderErrorCode.ORDER_NOT_PLACED,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
            )
        }
    }
}