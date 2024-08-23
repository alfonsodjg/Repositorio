package com.example.repositorio.data.modules.add_file_admin.repository

import com.example.repositorio.core.ApiClient
import com.example.repositorio.data.modules.add_file_admin.mapper.toDomain
import com.example.repositorio.domain.modules.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.modules.add_file_admin.model.PublicTypeDomainModel
import com.example.repositorio.domain.modules.add_file_admin.repository.IAddFileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImplAddFileRepository: IAddFileRepository {
    private val api = ApiClient.instance

    override suspend fun getAuthorsItems(): List<AuthorItemDomainModel>? {
        return withContext(Dispatchers.IO){
            val response = api.getAuthorsItemResponse()
            if (response.isSuccessful) {
                response.body()?.let {
                    println("Response Body: $it")
                    it.map { item -> item.toDomain() }
                }
            } else {
                println("Error: ${response.errorBody()?.string()}")
                null
            }
        }
    }

    override suspend fun getTypePublications(): List<PublicTypeDomainModel>? {
        return withContext(Dispatchers.IO){
            val response = api.getType()
           if (response.isSuccessful) response.body()?.map { it.toDomain() } else null
        }
    }
    /*override suspend fun uploadBook(
        titulo: String,
        imagenFile: File?,
        materia: String,
        fechaPublicacion: String,
        tipoPublicacion: String,
        pdfFile: File?,
        resumen: String,
        autor: String
    ): Result<ResponseBody> {
        return withContext(Dispatchers.IO) {
            try {
                // Crear RequestBody para los parámetros de texto
                val tituloBody = createRequestBody(titulo)
                val materiaBody = createRequestBody(materia)
                val fechaPublicacionBody = createRequestBody(fechaPublicacion)
                val tipoPublicacionBody = createRequestBody(tipoPublicacion)
                val resumenBody = createRequestBody(resumen)
                val autorBody = createRequestBody(autor)

                // Preparar los archivos como MultipartBody.Part
                val imagenPart = imagenFile?.let { prepareFilePart("imagen", it) }
                val pdfPart = pdfFile?.let { prepareFilePart("pdf", it) }

                // Asegúrate de que el método esté definido correctamente en tu interfaz
                val response = api.uploadFile(
                    tituloBody,
                    imagenPart,
                    materiaBody,
                    fechaPublicacionBody,
                    tipoPublicacionBody,
                    pdfPart,
                    resumenBody,
                    autorBody
                )

                if (response.isSuccessful) {
                    Result.success(response.body())
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }
    }

    private fun createRequestBody(value: String): RequestBody {
        return value.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    private fun prepareFilePart(partName: String, file: File): MultipartBody.Part {
        val requestFile = file.asRequestBody("application/octet-stream".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }*/
}