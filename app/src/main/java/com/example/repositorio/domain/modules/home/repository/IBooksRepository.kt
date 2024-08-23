package com.example.repositorio.domain.modules.home.repository

import com.example.repositorio.domain.modules.home.model.BookResponseDomainModel

interface IBooksRepository {

    suspend fun getBooks(token: String): BookResponseDomainModel?
}