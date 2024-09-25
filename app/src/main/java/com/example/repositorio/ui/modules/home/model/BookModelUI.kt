package com.example.repositorio.ui.modules.home.model
data class BookModelUI(
val info: InfoBookResponse = InfoBookResponse(),
val results: List<BookListResponse> = emptyList()
) {
    data class InfoBookResponse(
        val count: Int = -1,
        val next: Int = -1,
        val prev: Int = -1,
        val pages: Int = -1,
        val pageSize: Int = -1
    )

    data class BookListResponse(
        val id: Int = -1,
        val title: String = "",
        val image: String = "",
        val materia: String = "",
        val datePublication: String = "",
        val pdfFile: String = "",
        val resume: String = "",
        val publicationType: String = "",
        val author: List<String> = emptyList()
    )
}