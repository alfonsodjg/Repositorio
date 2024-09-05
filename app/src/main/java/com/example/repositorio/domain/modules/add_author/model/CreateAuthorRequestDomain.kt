package com.example.repositorio.domain.modules.add_author.model

import java.io.File

data class CreateAuthorRequestDomain(
    val files: List<File> = emptyList(),
    val name: String,
    val lastFather: String,
    val lastMother: String,
    val matricula: String,
    val asesorInterno: String,
    val asesorExterto: String,
    val carrera: Int?,
    val campus: Int?
)