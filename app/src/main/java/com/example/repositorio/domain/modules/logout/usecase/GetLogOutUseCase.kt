package com.example.repositorio.domain.modules.logout.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.logout.model.LogOutDomainModel
import com.example.repositorio.domain.modules.logout.repository.ILogOutRepository

class GetLogOutUseCase(
    private val repository: ILogOutRepository
) {
    suspend operator fun invoke(token: String): ServiceDomainHandler<LogOutDomainModel> =
        repository.getLogOut(token)
}
