package com.example.repositorio.domain.modules.reset_password.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.model.ChangePassRequestDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordDomainModel
import com.example.repositorio.domain.modules.reset_password.repository.IResetPasswordRepository

class GetChangePasswordUseCase(
    private val repository: IResetPasswordRepository
) {
    suspend operator fun invoke(
        code: String,
        password: String
    ): ServiceDomainHandler<ResetPasswordDomainModel> =
        repository.changePassword(ChangePassRequestDomainModel(code, password))
}