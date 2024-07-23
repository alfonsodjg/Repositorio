package com.example.repositorio.domain.login.usecase

import com.example.repositorio.data.login.model.LoginResponse
import com.example.repositorio.data.login.repository.ImplLoginRepository

class LoginUseCase {
    private val repository = ImplLoginRepository()

    suspend operator fun invoke(email: String, password: String): LoginResponse? =
        repository.loginRepository(email, password)
}