package com.example.repositorio.data.profile.repository

import com.example.repositorio.core.ApiClient
import com.example.repositorio.domain.profile.model.ProfileDomainModel
import com.example.repositorio.domain.profile.repository.IProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImplProfileRepository: IProfileRepository {
    private val apiNetwork = ApiClient.instance

    override suspend fun getUserInfo(token: String): ProfileDomainModel? {
        return withContext(Dispatchers.IO) {
            val response = apiNetwork.getUserInfo("Token $token")
            if (response.isSuccessful) response.body()?.toDomain() else null
        }
    }
}