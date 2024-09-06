package com.example.repositorio.data.modules.reset_password.model

import com.google.gson.annotations.SerializedName

data class ResetPassResponse(
    @SerializedName("email")
    val email: String?,
    @SerializedName("detail")
    val detail: String?
)
