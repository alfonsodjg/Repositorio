package com.example.repositorio.domain.modules.add_file_admin.usecase

import com.example.repositorio.data.modules.add_file_admin.repository.ImplAddFileRepository

class UploadBookUseCase {
    private val repository = ImplAddFileRepository()

    /*suspend operator fun invoke(
        titulo: String,
        imagenFile: File?,
        materia: String,
        fechaPublicacion: String,
        tipoPublicacion: String,
        pdfFile: File?,
        resumen: String,
        autor: String
    ): Result<ResponseBody> =
        repository.uploadBook(
            titulo,
            imagenFile,
            materia,
            fechaPublicacion,
            tipoPublicacion,
            pdfFile,
            resumen,
            autor
        )*/
}