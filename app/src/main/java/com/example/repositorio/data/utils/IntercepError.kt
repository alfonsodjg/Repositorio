package com.example.repositorio.data.utils

import com.example.repositorio.data.core.handler.ServiceError
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import java.net.UnknownHostException

fun Exception.castErrorToServiceDataError(): ServiceError {
    return when (this) {
        is RedirectResponseException -> {
            ServiceError.RedirectError(
                this.response.status.value,
                this.message,
                this.response.status.description
            )
        }

        is ClientRequestException -> {
            ServiceError.ClientError(
                this.response.status.value,
                this.message,
                this.response.status.description
            )
        }

        is ServerResponseException -> {
            ServiceError.ServerError(
                this.response.status.value,
                this.message,
                this.response.status.description
            )
        }

        is NoTransformationFoundException -> {
            ServiceError.CastException(
                code = 0,
                message = this.message ?: "",
                description = this.toString()
            )
        }
        is UnknownHostException -> {
            ServiceError.UnknownHostException(
                code = 0,
                message = this.message ?: "",
                description = this.toString()
            )
        }

        else -> {
            ServiceError.UnknownError(
                code = 0,
                message = this.message ?: "",
                description = this.toString()
            )
        }
    }
}