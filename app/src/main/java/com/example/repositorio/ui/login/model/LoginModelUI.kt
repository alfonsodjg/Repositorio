package com.example.repositorio.ui.login.model

data class LoginModelUI(
    val email : String,
    val password : String
)

data class LoginResponseModelUI(
    val token : String
)
