package com.example.repositorio.data.modules.add_file_admin.mapper

import com.example.repositorio.data.modules.add_file_admin.model.AuthorItemResponse
import com.example.repositorio.data.modules.add_file_admin.model.PublicTypeResponse
import com.example.repositorio.domain.modules.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.modules.add_file_admin.model.PublicTypeDomainModel

fun AuthorItemResponse.toDomain(): AuthorItemDomainModel {
    return AuthorItemDomainModel(
        name = name ?: "",
        lastName = lastName ?: ""
    )
}

fun PublicTypeResponse.toDomain(): PublicTypeDomainModel {
    return PublicTypeDomainModel(
        name = name?: ""
    )
}