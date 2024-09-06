package com.example.repositorio.data.modules.reset_password.repository

import com.example.repositorio.data.modules.reset_password.mapper.toDomain
import com.example.repositorio.data.modules.reset_password.model.ChangePassRequest
import com.example.repositorio.data.modules.reset_password.model.ResetPassRequest
import com.example.repositorio.data.modules.reset_password.model.ResetPassResponse
import com.example.repositorio.data.modules.reset_password.model.ResetPasswordVerificationResponse
import com.example.repositorio.data.modules.reset_password.resource.ResetPasswordResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.model.ChangePassRequestDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPassVerificationDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordRequestDomainModel
import com.example.repositorio.domain.modules.reset_password.repository.IResetPasswordRepository
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody

class ImplResetPasswordRepository : IResetPasswordRepository {
    override suspend fun resetPassword(request: ResetPasswordRequestDomainModel): ServiceDomainHandler<ResetPasswordDomainModel> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: ResetPassResponse = ktor.post(ResetPasswordResource.ResetPass()) {
                setBody(
                    ResetPassRequest(
                        email = request.email
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

    override suspend fun resetPasswordVerification(code: String): ServiceDomainHandler<ResetPassVerificationDomainModel> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: ResetPasswordVerificationResponse =
                ktor.get(ResetPasswordResource.ResetPassVerification(code = code)).body()
            ServiceDomainHandler.Success(response.toDomain())
        } catch (e: Exception) {
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }
    }

    override suspend fun changePassword(request: ChangePassRequestDomainModel): ServiceDomainHandler<ResetPasswordDomainModel> {
        val ktor = KtorConf.KtorClient()
        return try {
            val response: ResetPassResponse = ktor.post(ResetPasswordResource.ChangePassword()){
                setBody(
                    ChangePassRequest(
                        code = request.code,
                        password = request.password
                    )
                )
            }.body()
            ServiceDomainHandler.Success(response.toDomain())
        }catch (e: Exception){
            ServiceDomainHandler.Error(e.castErrorToServiceDataError().toServiceErrorDomain())
        }
    }
}