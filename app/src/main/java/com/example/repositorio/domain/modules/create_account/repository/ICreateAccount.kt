package com.example.repositorio.domain.modules.create_account.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account.model.CreateAccountRequestDomain
import com.example.repositorio.domain.modules.create_account.model.CreateAccountResponseDomainModel

interface ICreateAccount {
    suspend fun createAccount(request: CreateAccountRequestDomain): ServiceDomainHandler<CreateAccountResponseDomainModel>
}