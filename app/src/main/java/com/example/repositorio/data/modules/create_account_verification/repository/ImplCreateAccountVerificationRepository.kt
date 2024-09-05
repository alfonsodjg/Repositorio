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
    override suspend fun getCreateAccountVerification(code: String): HttpResponse {
       val ktor = KtorConf.KtorClient()
        /*return try {
            val response: CreateAccountVerificationResponse =
                ktor.get("${ApiEndpoint.CREATE_ACCOUNT_VERIFICATION}?code=$code").body()
            ServiceDomainHandler.Success(response.toDomain())
        }catch (e: Exception){
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }*/
        // Construir la URL de manera más segura utilizando URLBuilder
        val response: HttpResponse = ktor.get {
            url {
                takeFrom(ApiEndpoint.CREATE_ACCOUNT_VERIFICATION)
                parameters.append("code", code) // Evitar concatenación manual
            }
        }

        val responseBody = response.bodyAsText()
        println("Response body: $responseBody")

        val mappedResponse: CreateAccountVerificationResponse = response.body()
        return response
    }
}