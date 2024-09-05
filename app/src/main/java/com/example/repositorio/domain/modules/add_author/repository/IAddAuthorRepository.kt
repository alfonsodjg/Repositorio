package com.example.repositorio.domain.modules.add_author.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.add_author.model.AuthorResponseDomainModel
import com.example.repositorio.domain.modules.add_author.model.CampusDomainModel
import com.example.repositorio.domain.modules.add_author.model.CarrerasDomainModel
import com.example.repositorio.domain.modules.add_author.model.CreateAuthorRequestDomain

interface IAddAuthorRepository {
    suspend fun getCarreras(): ServiceDomainHandler<List<CarrerasDomainModel>>

    suspend fun getCampus(): ServiceDomainHandler<List<CampusDomainModel>>

    suspend fun createAuthor(
        token: String,
        request: CreateAuthorRequestDomain
    ): ServiceDomainHandler<AuthorResponseDomainModel>
}