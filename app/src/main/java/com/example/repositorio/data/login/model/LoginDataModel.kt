package com.example.repositorio.data.login.model

import com.example.repositorio.domain.login.model.LoginResponseDomainModel
import com.google.gson.annotations.SerializedName

data class UserDataModel(
    @SerializedName("email")
    val email : String,
    @SerializedName("password")
    val password : String
){
    fun toDomain() = UserDataModel(
        email = email,
        password = password
    )
}

data class LoginResponse(
    val token : String
){
    fun toDomain() = LoginResponseDomainModel(
        token = token
    )
}