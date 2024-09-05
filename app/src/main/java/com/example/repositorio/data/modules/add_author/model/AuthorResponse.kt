package com.example.repositorio.data.modules.add_author.model

import com.google.gson.annotations.SerializedName

data class AuthorResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("nombres")
    val name: String?,
    @SerializedName("apellido_paterno")
    val lastFather: String?,
    @SerializedName("apellido_materno")
    val lastMother: String?,
    @SerializedName("matricula")
    val matricula: String?,
    @SerializedName("asesor_interno")
    val asesorInterno: String?,
    @SerializedName("asesor_externo")
    val asesorExterto: String?,
    @SerializedName("carrera")
    val carrera: String?,
    @SerializedName("campus")
    val campus: String?
)
