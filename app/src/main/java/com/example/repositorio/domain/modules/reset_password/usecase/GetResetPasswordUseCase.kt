package com.example.repositorio.domain.modules.reset_password.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordRequestDomainModel
import com.example.repositorio.domain.modules.reset_password.repository.IResetPasswordRepository

class GetResetPasswordUseCase(
    private val repository: IResetPasswordRepository
) {
    suspend operator fun invoke(email: String): ServiceDomainHandler<ResetPasswordDomainModel> =
        repository.resetPassword(ResetPasswordRequestDomainModel(email))
}