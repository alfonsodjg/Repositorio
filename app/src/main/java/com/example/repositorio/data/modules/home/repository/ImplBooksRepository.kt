package com.example.repositorio.data.modules.home.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.repositorio.core.ApiClient
import com.example.repositorio.data.modules.home.mapper.toDomain
import com.example.repositorio.data.modules.home.model.BookResponse
import com.example.repositorio.data.modules.home.resource.BookResource
import com.example.repositorio.data.network.client.KtorConf
import com.example.repositorio.data.utils.castErrorToServiceDataError
import com.example.repositorio.data.utils.toServiceErrorDomain
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.core.utils.DecodeFilePdf
import com.example.repositorio.domain.core.utils.PdfBook
import com.example.repositorio.domain.modules.home.model.BookDomainModel
import com.example.repositorio.domain.modules.home.repository.IBooksRepository
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readBytes

class ImplBooksRepository: IBooksRepository {
    override suspend fun getBooks(token: String): ServiceDomainHandler<BookDomainModel> {
        val ktor = KtorConf.KtorClient()

        return try {
            val response: BookResponse = ktor.get(BookResource.BookResourceItem()){
                header("Authorization", "Token $token")
            }.body()
            ServiceDomainHandler.Success(response.toDomain())
        }catch (e: Exception){
            ServiceDomainHandler.Error(
                e.castErrorToServiceDataError().toServiceErrorDomain()
            )
        }

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override suspend fun getDownloadPDF(id: Int, token: String): ServiceDomainHandler<PdfBook> {
        val ktor = KtorConf.KtorClient()

        return try {
            val response: HttpResponse = ktor.get(BookResource.BookPDF(id = id)){
                header("Authorization", "Token $token")
            }
            val path = DecodeFilePdf().createFile(
                fileName = "Book($id).pdf",
                inputStream = response.readBytes()
            )
            ServiceDomainHandler.Success(PdfBook(path))
        }catch (e: Exception){
           ServiceDomainHandler.Error(
               e.castErrorToServiceDataError().toServiceErrorDomain()
           )
        }finally {
            ktor.close()
        }
    }
}