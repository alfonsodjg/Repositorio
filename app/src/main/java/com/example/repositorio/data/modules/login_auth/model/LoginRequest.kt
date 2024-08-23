package com.example.repositorio.data.modules.login_auth.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password : String
)
