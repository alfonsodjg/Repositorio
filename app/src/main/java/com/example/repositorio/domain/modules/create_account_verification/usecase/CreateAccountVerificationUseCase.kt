package com.example.repositorio.domain.modules.create_account_verification.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account_verification.model.CreateAccountVerificationDomainModel
import com.example.repositorio.domain.modules.create_account_verification.repository.ICreateAccountVerification
import io.ktor.client.statement.HttpResponse

class CreateAccountVerificationUseCase(
    private val repository: ICreateAccountVerification
) {
    suspend operator fun invoke(code:String): HttpResponse =
        repository.getCreateAccountVerification(code)
}