package com.example.repositorio.data.profile.model

import com.example.repositorio.domain.profile.model.ProfileDomainModel
import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("apellido_materno")
    val apellido_materno: String,
    @SerializedName("matricula")
    val matricula: String
){
    fun toDomain() = ProfileDomainModel(
        first_name, last_name, apellido_materno, matricula
    )
}