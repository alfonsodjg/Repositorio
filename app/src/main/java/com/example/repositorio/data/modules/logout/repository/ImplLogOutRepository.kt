package com.example.repositorio.data.modules.logout.repository

import com.example.repositorio.data.modules.login_auth.resource.LoginResource
import com.example.repositorio.data.modules.logout.mapper.toDomain
import com.example.repositorio.data.modules.logout.model.LogOutResponse
import com.example.repositorio.data.modules.logout.resource.LogOutResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.logout.model.LogOutDomainModel
import com.example.repositorio.domain.modules.logout.repository.ILogOutRepository
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.request.header

class ImplLogOutRepository: ILogOutRepository {
    override suspend fun getLogOut(token: String): ServiceDomainHandler<LogOutDomainModel> {
        val ktor = KtorConf.KtorClient()

        return try {
            val response: LogOutResponse = ktor.get(LogOutResource()){
                header("Authorization", "Token $token")
            }.body()
            return ServiceDomainHandler.Success(response.toDomain())
        }catch (e: Exception){
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError()
                    .toServiceErrorDomain()
            )
        }
    }
}