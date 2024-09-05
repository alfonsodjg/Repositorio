package com.example.repositorio.ui.modules.add_author.model

import com.example.repositorio.domain.modules.add_author.model.CreateAuthorRequestDomain
import java.io.File

data class CreateAuthorRequestUI(
    val files: List<File> = emptyList(),
    val name: String = "",
    val lastFather: String = "",
    val lastMother: String = "",
    val matricula: String = "",
    val asesorInterno: String = "",
    val asesorExterto: String = "",
    val carrera: Int? = null,
    val campus: Int? = null
)
fun CreateAuthorRequestUI.toDomain(): CreateAuthorRequestDomain =
    CreateAuthorRequestDomain(
        files = files,
        name = name,
        lastFather = lastFather,
        lastMother = lastMother,
        matricula = matricula,
        asesorInterno = asesorInterno,
        asesorExterto = asesorExterto,
        carrera = carrera,
        campus = campus
    )