package com.example.repositorio.domain.modules.reset_password.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.model.ChangePassRequestDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPassVerificationDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordRequestDomainModel

interface IResetPasswordRepository {
    suspend fun resetPassword(request: ResetPasswordRequestDomainModel): ServiceDomainHandler<ResetPasswordDomainModel>
    suspend fun resetPasswordVerification(code: String): ServiceDomainHandler<ResetPassVerificationDomainModel>
    suspend fun changePassword(request: ChangePassRequestDomainModel): ServiceDomainHandler<ResetPasswordDomainModel>
}