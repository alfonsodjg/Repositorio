package com.example.repositorio.ui.add_file_admin.viewstate

import com.example.repositorio.ui.add_file_admin.model.AuthorsModelUI
import com.example.repositorio.ui.add_file_admin.model.PublicTypesModelUI

data class AuthorsViewState(
    val authors: List<AuthorsModelUI> = emptyList(),
    val types: List<PublicTypesModelUI> = emptyList()
) {
    fun updateAuthorsList(
        authors: List<AuthorsModelUI>
    ) = copy(authors = authors)

    fun updateTypes(
        types: List<PublicTypesModelUI>
    ) = copy(types = types)
}