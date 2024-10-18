package com.codergm.orderser.external.decoder


import com.codergm.orderser.exception.OrderPlacingException
import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.ErrorDecoder
import org.codergm.ostore.common.exception.product.ProductException
import org.codergm.ostore.common.model.ErrorCode
import org.codergm.ostore.common.model.ErrorResponse

import org.springframework.http.HttpStatus

open class CustomErrorDecoder : ErrorDecoder {

    override fun decode(s: String?, response: Response?): Exception {
        return try {
            val body = response?.body()?.asInputStream()?.bufferedReader().use { it?.readText() }
            val objectMapper = ObjectMapper()
            val errorResponse: ErrorResponse = objectMapper.readValue(body, ErrorResponse::class.java)

            ProductException(
                errorResponse.errorMessage,
                errorResponse.errorCode,
                errorResponse.httpStatusCode
            )
        } catch (e: Exception) {
            OrderPlacingException(
                e.message!!,
                ErrorCode.ORDER_NOT_PLACED,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
            )
        }
    }
}