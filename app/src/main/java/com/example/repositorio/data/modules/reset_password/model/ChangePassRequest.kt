package com.example.repositorio.data.modules.reset_password.model

import com.google.gson.annotations.SerializedName

data class ChangePassRequest(
    @SerializedName("code")
    val code: String,
    @SerializedName("password")
    val password: String
)
