package com.example.repositorio.ui.add_file_admin.mapper

import com.example.repositorio.domain.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.add_file_admin.model.PublicTypeDomainModel
import com.example.repositorio.ui.add_file_admin.model.AuthorsModelUI
import com.example.repositorio.ui.add_file_admin.model.PublicTypesModelUI

fun AuthorItemDomainModel.toUI(): AuthorsModelUI{
    return AuthorsModelUI(
        name = name,
        lastName = lastName
    )
}

fun PublicTypeDomainModel.toUI(): PublicTypesModelUI{
    return PublicTypesModelUI(
        name = name
    )
}