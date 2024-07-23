package com.example.repositorio.domain.login.repository

import com.example.repositorio.data.login.model.LoginResponse

interface ILoginRepository {

    suspend fun loginRepository(email: String, password: String): LoginResponse?
}