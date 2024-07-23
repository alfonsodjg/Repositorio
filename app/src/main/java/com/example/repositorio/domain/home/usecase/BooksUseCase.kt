package com.example.repositorio.domain.home.usecase

import com.example.repositorio.data.home.repository.ImplBooksRepository
import com.example.repositorio.domain.home.model.BookResponseDomainModel

class BooksUseCase {
    private val repository = ImplBooksRepository()
    suspend fun getBooks(token: String): BookResponseDomainModel? =
        repository.getBooks(token)
}