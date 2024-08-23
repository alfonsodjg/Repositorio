package com.example.repositorio.domain.modules.home.model

data class BooksDomainModel(
    val id: Int,
    val titulo: String,
    val imagen: String,
    val materia: String
)

data class BookResponseDomainModel(
    val results: List<BooksDomainModel>,
    val info: PageInfoDomainModel
)

data class PageInfoDomainModel(
    val pages: Int
)