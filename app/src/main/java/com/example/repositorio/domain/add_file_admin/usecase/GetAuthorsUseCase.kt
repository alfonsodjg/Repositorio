package com.example.repositorio.domain.add_file_admin.usecase

import com.example.repositorio.data.add_file_admin.repository.ImplAddFileRepository
import com.example.repositorio.domain.add_file_admin.model.AuthorItemDomainModel

class GetAuthorsUseCase {
    private val repository = ImplAddFileRepository()

    suspend operator fun invoke(): List<AuthorItemDomainModel>? =
        repository.getAuthorsItems()
}