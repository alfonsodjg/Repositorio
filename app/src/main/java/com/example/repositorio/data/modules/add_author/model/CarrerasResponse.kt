package com.example.repositorio.data.modules.add_author.model

import com.google.gson.annotations.SerializedName

data class CarrerasResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("nombre")
    val name: String?
)
