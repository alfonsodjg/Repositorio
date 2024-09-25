package com.example.repositorio.ui.modules.home.mapper

import com.example.repositorio.domain.modules.home.model.BookDomainModel
import com.example.repositorio.ui.modules.home.model.BookModelUI

fun BookDomainModel.toUI(): BookModelUI =
    BookModelUI(
        info = info.toUI(),
        results = results.map { it.toUI() }
    )

fun BookDomainModel.InfoBookResponse.toUI(): BookModelUI.InfoBookResponse =
    BookModelUI.InfoBookResponse(
        count = count,
        next = next,
        prev = prev,
        pages = pages,
        pageSize = pageSize
    )

fun BookDomainModel.BookListResponse.toUI(): BookModelUI.BookListResponse =
    BookModelUI.BookListResponse(
        id = id,
        title = title,
        image = image,
        materia = materia,
        datePublication = datePublication,
        pdfFile = pdfFile,
        resume = resume,
        publicationType = publicationType,
        author = author
    )

