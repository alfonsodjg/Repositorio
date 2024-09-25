package com.example.repositorio.data.modules.home.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("info")
    val info: InfoBookResponse?,
    @SerializedName("results")
    val results: List<BookListResponse>?
){
    data class InfoBookResponse(
        @SerializedName("count")
        val count: Int?,
        @SerializedName("next")
        val next: Int?,
        @SerializedName("prev")
        val prev: Int?,
        @SerializedName("pages")
        val pages: Int?,
        @SerializedName("page_size")
        val pageSize: Int?
    )
    data class BookListResponse(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("titulo")
        val title: String?,
        @SerializedName("imagen")
        val image: String?,
        @SerializedName("materia")
        val materia: String?,
        @SerializedName("fecha_publicacion")
        val datePublication: String?,
        @SerializedName("pdf")
        val pdfFile: String?,
        @SerializedName("resumen")
        val resume: String?,
        @SerializedName("tipo_de_publicacion")
        val publicationType: String?,
        @SerializedName("autor")
        val author: List<String>?
    )
}
