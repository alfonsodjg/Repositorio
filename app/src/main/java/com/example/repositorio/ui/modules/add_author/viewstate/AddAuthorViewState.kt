package com.example.repositorio.ui.modules.add_author.viewstate

import com.example.repositorio.ui.modules.add_author.model.AuthorModelUI
import com.example.repositorio.ui.modules.add_author.model.CampusModelUI
import com.example.repositorio.ui.modules.add_author.model.CarrerasModelUI
import com.example.repositorio.ui.modules.add_author.model.CreateAuthorRequestUI
import java.io.File

data class AddAuthorViewState(
    val carreras: List<CarrerasModelUI> = emptyList(),
    val campus: List<CampusModelUI> = emptyList(),
    val author: AuthorModelUI = AuthorModelUI(),
    val requestUI: CreateAuthorRequestUI = CreateAuthorRequestUI()
) {
    fun updateCarreras(
        carreras: List<CarrerasModelUI> = emptyList()
    ) = copy(carreras = carreras)

    fun updateCampus(
        campus: List<CampusModelUI> = emptyList()
    ) = copy(campus = campus)

    fun updateAuthor(
        author: AuthorModelUI
    ) = copy(author = author)


    fun updateRequest(
        requestUI: CreateAuthorRequestUI
    ) = copy(
        requestUI = requestUI
    )
}