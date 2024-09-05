package com.example.repositorio.data.modules.create_account_verification.model

import com.google.gson.annotations.SerializedName

data class CreateAccountVerificationResponse(
    @SerializedName("success")
    val success: String?,
    @SerializedName("detail")
    val detail: String?
)
//Cambias el tipo de datos en domain e UI
