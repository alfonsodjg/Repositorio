package com.example.repositorio.data.home.repository

import com.example.repositorio.core.ApiClient
import com.example.repositorio.domain.home.model.BookResponseDomainModel
import com.example.repositorio.domain.home.repository.IBooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImplBooksRepository: IBooksRepository{
    private val apiNetwork = ApiClient.instance

    override suspend fun getBooks(token: String): BookResponseDomainModel? {
        return withContext(Dispatchers.IO) {
            val response = apiNetwork.getBooks("Token $token")
            if (response.isSuccessful) response.body()?.toDomain() else null
        }
    }
}