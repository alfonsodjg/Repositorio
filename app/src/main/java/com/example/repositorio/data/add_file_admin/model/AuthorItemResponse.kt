package com.example.repositorio.data.add_file_admin.model

import com.google.gson.annotations.SerializedName

data class AuthorItemResponse(
    @SerializedName("nombres")
    val name: String?,
    @SerializedName("apellido_paterno")
    val lastName: String?
)
