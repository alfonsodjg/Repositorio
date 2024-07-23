package com.example.repositorio.ui.home.model

import com.example.repositorio.domain.home.model.BooksDomainModel

data class BooksModelUI(
    val id: Int? = 0,
    val titulo: String? = "",
    val imagen: String? = "",
    val materia: String? = ""
)

data class BookResponseModelUI(
    val results: List<BooksDomainModel> = emptyList(),
    val info: PageInfoModelUI= PageInfoModelUI()
)

data class PageInfoModelUI(
    val pages: Int?=0
)