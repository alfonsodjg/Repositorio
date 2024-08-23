package com.example.repositorio.data.utils

import com.example.repositorio.data.core.handler.ServiceError
import com.example.repositorio.domain.core.handler.ServiceErrorDomain

fun ServiceError.toServiceErrorDomain(): ServiceErrorDomain {
    return when (this) {
        is ServiceError.AuthError -> {
            ServiceErrorDomain.AuthError(
                this.code,
                this.message,
                this.description
            )
        }
        is ServiceError.CastException -> {
            ServiceErrorDomain.CastException(
                this.code,
                this.message,
                this.description
            )
        }
        is ServiceError.ClientError -> {
            ServiceErrorDomain.ClientError(
                this.code,
                this.message,
                this.description
            )
        }
        is ServiceError.RedirectError -> {
            ServiceErrorDomain.RedirectError(
                this.code,
                this.message,
                this.description
            )
        }
        is ServiceError.ServerError -> {
            ServiceErrorDomain.ServerError(
                this.code,
                this.message,
                this.description
            )
        }
        is ServiceError.UnknownError -> {
            ServiceErrorDomain.UnknownError(
                this.code,
                this.message,
                this.description
            )
        }
        is ServiceError.UnknownHostException -> {
            ServiceErrorDomain.UnknownHostException(
                this.code,
                this.message,
                this.description
            )
        }
    }
}