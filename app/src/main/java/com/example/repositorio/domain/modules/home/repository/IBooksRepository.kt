package com.example.repositorio.domain.modules.home.repository

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.core.utils.PdfBook
import com.example.repositorio.domain.modules.home.model.BookDomainModel
import io.ktor.client.statement.HttpResponse

interface IBooksRepository {
    suspend fun getBooks(token: String): ServiceDomainHandler<BookDomainModel>
    suspend fun getDownloadPDF(id: Int, token: String): ServiceDomainHandler<PdfBook>
}