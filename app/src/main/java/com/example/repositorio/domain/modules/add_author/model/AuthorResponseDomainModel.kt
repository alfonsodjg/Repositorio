package com.example.repositorio.domain.modules.add_author.model

data class AuthorResponseDomainModel(
    val id: Int,
    val name: String,
    val lastFather: String,
    val lastMother: String,
    val matricula: String,
    val asesorInterno: String,
    val asesorExterto: String,
    val carrera: String,
    val campus: String
)
