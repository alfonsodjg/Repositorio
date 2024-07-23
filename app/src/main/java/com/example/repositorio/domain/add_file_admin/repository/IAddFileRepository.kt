package com.example.repositorio.domain.add_file_admin.repository

import com.example.repositorio.data.add_file_admin.model.PublicTypeResponse
import com.example.repositorio.domain.add_file_admin.model.AuthorItemDomainModel
import com.example.repositorio.domain.add_file_admin.model.PublicTypeDomainModel

interface IAddFileRepository {
    suspend fun getAuthorsItems(): List<AuthorItemDomainModel>?
    suspend fun getTypePublications(): List<PublicTypeDomainModel>?
}