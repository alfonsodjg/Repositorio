package com.example.repositorio.data.modules.create_account.model

import com.google.gson.annotations.SerializedName

data class CreateAccountRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("matricula")
    val matricula: String,
    @SerializedName("apellido_materno")
    val apellidoMaterno: String
)
