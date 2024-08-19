package com.example.repositorio.domain.add_file_admin.repository

import com.example.repositorio.data.add_file_admin.model.PublicTypeResponse
import com.example.repositorio.domain.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.add_file_admin.model.PublicTypeDomainModel
import okhttp3.ResponseBody
import java.io.File

interface IAddFileRepository {
    suspend fun getAuthorsItems(): List<AuthorItemDomainModel>?
    suspend fun getTypePublications(): List<PublicTypeDomainModel>?

    /*suspend fun uploadBook(
        titulo: String,
        imagenFile: File?,
        materia: String,
        fechaPublicacion: String,
        tipoPublicacion: String,
        pdfFile: File?,
        resumen: String,
        autor: String
    ): Result<ResponseBody>*/
}