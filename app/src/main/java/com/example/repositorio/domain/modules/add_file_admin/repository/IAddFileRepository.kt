package com.example.repositorio.domain.modules.add_file_admin.repository

import com.example.repositorio.domain.modules.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.modules.add_file_admin.model.PublicTypeDomainModel

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