package com.example.repositorio.data.add_file_admin.repository

import com.example.repositorio.core.ApiClient
import com.example.repositorio.data.add_file_admin.mapper.toDomain
import com.example.repositorio.data.add_file_admin.model.PublicTypeResponse
import com.example.repositorio.domain.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.add_file_admin.model.PublicTypeDomainModel
import com.example.repositorio.domain.add_file_admin.repository.IAddFileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImplAddFileRepository: IAddFileRepository {
    private val api = ApiClient.instance

    override suspend fun getAuthorsItems(): List<AuthorItemDomainModel>? {
        return withContext(Dispatchers.IO){
            val response = api.getAuthorsItemResponse()
            if (response.isSuccessful) {
                response.body()?.let {
                    println("Response Body: $it")
                    it.map { item -> item.toDomain() }
                }
            } else {
                println("Error: ${response.errorBody()?.string()}")
                null
            }
        }
    }

    override suspend fun getTypePublications(): List<PublicTypeDomainModel>? {
        return withContext(Dispatchers.IO){
            val response = api.getType()
           if (response.isSuccessful) response.body()?.map { it.toDomain() } else null
        }
    }
}