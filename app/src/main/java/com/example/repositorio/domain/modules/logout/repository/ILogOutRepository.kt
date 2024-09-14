package com.example.repositorio.domain.modules.logout.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.logout.model.LogOutDomainModel

interface ILogOutRepository {
    suspend fun getLogOut(token: String): ServiceDomainHandler<LogOutDomainModel>
}