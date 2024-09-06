package com.example.repositorio.domain.modules.reset_password.model

data class ChangePassRequestDomainModel(
    val code: String,
    val password: String
)
