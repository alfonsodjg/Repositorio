package com.example.repositorio.domain.add_file_admin.usecase

import com.example.repositorio.data.add_file_admin.repository.ImplAddFileRepository
import com.example.repositorio.domain.add_file_admin.model.PublicTypeDomainModel

class GetTypePublicationsUseCase {
    private val repository = ImplAddFileRepository()

    suspend operator fun invoke(): List<PublicTypeDomainModel>? =
        repository.getTypePublications()
}