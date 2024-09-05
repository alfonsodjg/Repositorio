package com.example.repositorio.data.modules.add_author.model

import com.google.gson.annotations.SerializedName

data class CampusResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("nombre")
    val name: String?
)
