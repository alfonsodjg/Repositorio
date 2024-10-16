package com.example.repositorio.domain.modules.add_file_admin.usecase

import com.example.repositorio.data.modules.add_file_admin.repository.ImplAddFileRepository
import com.example.repositorio.domain.modules.add_file_admin.model.PublicTypeDomainModel

class GetTypePublicationsUseCase {
    private val repository = ImplAddFileRepository()

    suspend operator fun invoke(): List<PublicTypeDomainModel>? =
        repository.getTypePublications()
}