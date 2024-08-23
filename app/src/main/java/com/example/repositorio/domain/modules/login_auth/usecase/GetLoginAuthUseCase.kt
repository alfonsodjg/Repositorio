package com.example.repositorio.domain.modules.login_auth.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.login_auth.model.LoginDomainModel
import com.example.repositorio.domain.modules.login_auth.model.LoginRequestDomainModel
import com.example.repositorio.domain.modules.login_auth.repository.ILoginAuthRepository

class GetLoginAuthUseCase(
    private val repository: ILoginAuthRepository
) {
    suspend operator fun invoke(email: String, password: String): ServiceDomainHandler<LoginDomainModel> =
        repository.loginRepository(LoginRequestDomainModel(email, password))
}