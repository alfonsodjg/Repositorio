package com.example.repositorio.domain.modules.add_author.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.add_author.model.AuthorResponseDomainModel
import com.example.repositorio.domain.modules.add_author.model.CreateAuthorRequestDomain
import com.example.repositorio.domain.modules.add_author.repository.IAddAuthorRepository

class GetAuthorCreatedUseCase(
    private val repository: IAddAuthorRepository
) {
    suspend operator fun invoke(
        token: String,
        requestDomain: CreateAuthorRequestDomain
    ): ServiceDomainHandler<AuthorResponseDomainModel> =
        repository.createAuthor(token, requestDomain)
}