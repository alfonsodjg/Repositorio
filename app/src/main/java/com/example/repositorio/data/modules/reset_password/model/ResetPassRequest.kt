package com.example.repositorio.data.modules.reset_password.model

import com.google.gson.annotations.SerializedName

data class ResetPassRequest(
    @SerializedName("email")
    val email: String?
)
