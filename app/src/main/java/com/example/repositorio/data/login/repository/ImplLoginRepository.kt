package com.example.repositorio.data.login.repository

import com.example.repositorio.core.ApiClient
import com.example.repositorio.data.login.model.LoginResponse
import com.example.repositorio.data.login.model.UserDataModel
import com.example.repositorio.domain.login.repository.ILoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImplLoginRepository : ILoginRepository {

    private val apiNetwork = ApiClient.instance

    override suspend fun loginRepository(email: String, password: String): LoginResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiNetwork.postLogin(UserDataModel(email, password))
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}