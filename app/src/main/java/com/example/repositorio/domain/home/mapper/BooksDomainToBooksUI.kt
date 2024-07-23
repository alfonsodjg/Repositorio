package com.example.repositorio.domain.home.mapper

import com.example.repositorio.domain.home.model.BookResponseDomainModel
import com.example.repositorio.domain.home.model.BooksDomainModel
import com.example.repositorio.domain.home.model.PageInfoDomainModel
import com.example.repositorio.ui.home.model.BookResponseModelUI
import com.example.repositorio.ui.home.model.BooksModelUI
import com.example.repositorio.ui.home.model.PageInfoModelUI

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