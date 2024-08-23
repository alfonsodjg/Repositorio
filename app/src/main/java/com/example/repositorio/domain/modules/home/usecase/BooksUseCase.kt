package com.example.repositorio.domain.modules.home.usecase

import com.example.repositorio.data.modules.home.repository.ImplBooksRepository
import com.example.repositorio.domain.modules.home.model.BookResponseDomainModel

class BooksUseCase {
    private val repository = ImplBooksRepository()
    suspend fun getBooks(token: String): BookResponseDomainModel? =
        repository.getBooks(token)
}