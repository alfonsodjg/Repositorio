package com.example.repositorio.domain.modules.home.usecase

import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.core.utils.PdfBook
import com.example.repositorio.domain.modules.home.repository.IBooksRepository

class BookPdfDownloadUseCase(
    private val repository: IBooksRepository
){
    suspend operator fun invoke(id: Int, token: String): ServiceDomainHandler<PdfBook> =
        repository.getDownloadPDF(id, token)
}