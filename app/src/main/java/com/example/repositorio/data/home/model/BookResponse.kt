package com.example.repositorio.data.home.model


import com.example.repositorio.domain.home.model.BookResponseDomainModel
import com.example.repositorio.domain.home.model.BooksDomainModel
import com.example.repositorio.domain.home.model.PageInfoDomainModel
import com.google.gson.annotations.SerializedName

data class BooksDataModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("imagen")
    val imagen: String,
    @SerializedName("materia")
    val materia: String
){
    fun mapToDomain() =
        BooksDomainModel(
            id, titulo, imagen, materia
        )
}

data class BookResponse(
    @SerializedName("results")
    val results: List<BooksDataModel>,
    @SerializedName("info")
    val info: PageInfo
){
    fun toDomain() = BookResponseDomainModel(
        results.map { it.mapToDomain() },
        info.toDomain()
    )
}

data class PageInfo(
    @SerializedName("pages")
    val pages: Int
){
    fun toDomain() = PageInfoDomainModel(
        pages
    )
}
