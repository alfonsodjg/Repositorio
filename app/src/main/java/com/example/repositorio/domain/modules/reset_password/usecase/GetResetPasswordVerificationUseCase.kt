package com.example.repositorio.domain.modules.reset_password.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.model.ResetPassVerificationDomainModel
import com.example.repositorio.domain.modules.reset_password.repository.IResetPasswordRepository

class GetResetPasswordVerificationUseCase(
    private val repository: IResetPasswordRepository
) {
    suspend operator fun invoke(code: String): ServiceDomainHandler<ResetPassVerificationDomainModel> =
        repository.resetPasswordVerification(code)
}