package com.example.repositorio.domain.modules.home.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.home.model.BookDomainModel
import com.example.repositorio.domain.modules.home.repository.IBooksRepository
import io.ktor.client.statement.HttpResponse

class BooksUseCase(
    private val repository: IBooksRepository
) {
    suspend fun getBooks(token: String): ServiceDomainHandler<BookDomainModel> =
        repository.getBooks(token)
}