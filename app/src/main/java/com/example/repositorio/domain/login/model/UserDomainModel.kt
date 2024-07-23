package com.example.repositorio.domain.login.model

data class UserDomainModel(
    val email : String,
    val password : String
)

data class LoginResponseDomainModel(
    val token : String
)
