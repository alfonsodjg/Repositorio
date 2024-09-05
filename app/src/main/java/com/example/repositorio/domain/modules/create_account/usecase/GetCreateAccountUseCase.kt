package com.example.repositorio.domain.modules.create_account.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account.model.CreateAccountRequestDomain
import com.example.repositorio.domain.modules.create_account.model.CreateAccountResponseDomainModel
import com.example.repositorio.domain.modules.create_account.repository.ICreateAccount

class GetCreateAccountUseCase(
    private val repository: ICreateAccount
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        matricula: String,
        apellidoMaterno: String
    ): ServiceDomainHandler<CreateAccountResponseDomainModel> =
        repository.createAccount(
            CreateAccountRequestDomain(
                email = email,
                password = password,
                firstName = firstName,
                lastName = lastName,
                matricula = matricula,
                apellidoMaterno = apellidoMaterno
            )
        )
}