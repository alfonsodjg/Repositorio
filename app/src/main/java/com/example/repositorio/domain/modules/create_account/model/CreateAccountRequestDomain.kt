package com.example.repositorio.domain.modules.create_account.model

import com.google.gson.annotations.SerializedName

data class CreateAccountRequestDomain(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val matricula: String,
    val apellidoMaterno: String
)
