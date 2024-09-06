package com.example.repositorio.data.modules.create_account_verification.repository

import com.example.repositorio.data.modules.create_account_verification.mapper.toDomain
import com.example.repositorio.data.modules.create_account_verification.model.CreateAccountVerificationResponse
import com.example.repositorio.data.modules.create_account_verification.resource.CreateAccountVerificationResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.network.endpoint.ApiEndpoint
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account_verification.model.CreateAccountVerificationDomainModel
import com.example.repositorio.domain.modules.create_account_verification.repository.ICreateAccountVerification
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.takeFrom

class ImplCreateAccountVerificationRepository: ICreateAccountVerification {
    override suspend fun getCreateAccountVerification(code: String): ServiceDomainHandler<CreateAccountVerificationDomainModel> {
       val ktor = KtorConf.KtorClient()
        return try {
            val response: CreateAccountVerificationResponse =
                ktor.get(CreateAccountVerificationResource.CreateAccountVerification(code = code)).body()
            ServiceDomainHandler.Success(response.toDomain())
        }catch (e: Exception){
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }

    }
}