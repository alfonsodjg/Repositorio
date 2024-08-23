package com.example.repositorio.data.modules.login_auth.repository

import com.example.repositorio.data.modules.login_auth.mapper.toDomain
import com.example.repositorio.data.modules.login_auth.model.LoginRequest
import com.example.repositorio.data.modules.login_auth.model.LoginResponse
import com.example.repositorio.data.modules.login_auth.resource.LoginResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.login_auth.model.LoginDomainModel
import com.example.repositorio.domain.modules.login_auth.model.LoginRequestDomainModel
import com.example.repositorio.domain.modules.login_auth.repository.ILoginAuthRepository
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody

class ImplLoginAuthRepository: ILoginAuthRepository {
    override suspend fun loginRepository(request: LoginRequestDomainModel): ServiceDomainHandler<LoginDomainModel> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: LoginResponse = ktor.post(LoginResource()){
                setBody(
                    LoginRequest(
                        email = request.email,
                        password = request.password
                    )
                )
            }.body()
            ServiceDomainHandler.Success(response.toDomain())
        }catch (e: Exception){
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }
    }
}