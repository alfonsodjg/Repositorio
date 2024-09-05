package com.example.repositorio.data.modules.create_account.model

import com.google.gson.annotations.SerializedName

data class CreateAccountResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("message")
    val message: String?
)
