package com.example.repositorio.domain.modules.create_account_verification.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account_verification.model.CreateAccountVerificationDomainModel
import io.ktor.client.statement.HttpResponse

interface ICreateAccountVerification {
    suspend fun getCreateAccountVerification(code: String): HttpResponse
}