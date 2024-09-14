package com.example.repositorio.data.modules.logout.model

import com.google.gson.annotations.SerializedName

data class LogOutResponse(
    @SerializedName("success")
    val success: String?,
    @SerializedName("detail")
    val detail: String?
)
