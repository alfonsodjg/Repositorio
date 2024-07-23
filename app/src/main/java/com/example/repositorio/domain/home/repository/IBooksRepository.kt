package com.example.repositorio.domain.home.repository

import com.example.repositorio.domain.home.model.BookResponseDomainModel

interface IBooksRepository {

    suspend fun getBooks(token: String): BookResponseDomainModel?
}