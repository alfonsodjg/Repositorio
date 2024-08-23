package com.example.repositorio.domain.modules.login_auth.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.login_auth.model.LoginDomainModel
import com.example.repositorio.domain.modules.login_auth.model.LoginRequestDomainModel

interface ILoginAuthRepository {
    suspend fun loginRepository(request: LoginRequestDomainModel): ServiceDomainHandler<LoginDomainModel>
}