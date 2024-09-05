package com.example.repositorio.data.modules.create_account.repository

import com.example.repositorio.data.modules.create_account.mapper.toDomain
import com.example.repositorio.data.modules.create_account.model.CreateAccountRequest
import com.example.repositorio.data.modules.create_account.model.CreateAccountResponse
import com.example.repositorio.data.modules.create_account.resource.CreateAccountResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account.model.CreateAccountRequestDomain
import com.example.repositorio.domain.modules.create_account.model.CreateAccountResponseDomainModel
import com.example.repositorio.domain.modules.create_account.repository.ICreateAccount
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody

class ImplCreateAccount : ICreateAccount {
    override suspend fun createAccount(request: CreateAccountRequestDomain): ServiceDomainHandler<CreateAccountResponseDomainModel> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: CreateAccountResponse = ktor.post(CreateAccountResource.CreateAccount()) {
                setBody(
                    CreateAccountRequest(
                        email = request.email,
                        password = request.password,
                        firstName = request.firstName,
                        lastName = request.lastName,
                        matricula = request.matricula,
                        apellidoMaterno = request.apellidoMaterno
                    )
                )
            }.body()
            ServiceDomainHandler.Success(response.toDomain())
        } catch (e: Exception) {
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }
    }
}