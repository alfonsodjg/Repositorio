package com.example.repositorio.data.modules.add_author.model

import com.google.gson.annotations.SerializedName
import java.io.File

data class CreateAuthorRequest(
    @SerializedName("archivos")
    val files: List<File> = emptyList(),
    @SerializedName("nombres")
    val name: String,
    @SerializedName("apellido_paterno")
    val lastFather: String,
    @SerializedName("apellido_materno")
    val lastMother: String,
    @SerializedName("matricula")
    val matricula: String,
    @SerializedName("asesor_interno")
    val asesorInterno: String,
    @SerializedName("asesor_externo")
    val asesorExterto: String,
    @SerializedName("carrera")
    val carrera: Int?,
    @SerializedName("campus")
    val campus: Int?
)
