package com.example.repositorio.domain.modules.home.mapper

import com.example.repositorio.domain.modules.home.model.BookResponseDomainModel
import com.example.repositorio.domain.modules.home.model.BooksDomainModel
import com.example.repositorio.domain.modules.home.model.PageInfoDomainModel
import com.example.repositorio.ui.modules.home.model.BookResponseModelUI
import com.example.repositorio.ui.modules.home.model.BooksModelUI
import com.example.repositorio.ui.modules.home.model.PageInfoModelUI

fun BooksDomainModel.toUI() = BooksModelUI(
    id = id,
    titulo = titulo,
    imagen = imagen,
    materia = materia
)

fun BookResponseDomainModel.toUI() = BookResponseModelUI(
    results = results,
    info = info.toUI()
)

fun PageInfoDomainModel.toUI() = PageInfoModelUI(
    pages = pages
)