package com.example.repositorio.data.modules.home.mapper

import com.example.repositorio.data.modules.home.model.BookResponse
import com.example.repositorio.domain.modules.home.model.BookDomainModel

fun BookResponse.toDomain(): BookDomainModel =
    BookDomainModel(
        info = info?.toDomain() ?: BookDomainModel.InfoBookResponse(),
        results = results?.map { it.toDomain() } ?: emptyList()
    )

fun BookResponse.InfoBookResponse.toDomain(): BookDomainModel.InfoBookResponse =
    BookDomainModel.InfoBookResponse(
        count = count ?: -1,
        next = next ?: -1,
        prev = prev ?: -1,
        pages = pages ?: -1,
        pageSize = pageSize ?: -1
    )

fun BookResponse.BookListResponse.toDomain(): BookDomainModel.BookListResponse =
    BookDomainModel.BookListResponse(
        id = id ?: -1,
        title = title ?: "",
        image = image ?: "",
        materia = materia ?: "",
        datePublication = datePublication ?: "",
        pdfFile = pdfFile ?: "",
        resume = resume ?: "",
        publicationType = publicationType ?: "",
        author = author ?: emptyList()
    )