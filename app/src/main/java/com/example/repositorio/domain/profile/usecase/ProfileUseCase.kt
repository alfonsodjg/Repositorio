package com.example.repositorio.domain.profile.usecase

import com.example.repositorio.data.profile.repository.ImplProfileRepository
import com.example.repositorio.domain.profile.model.ProfileDomainModel

class ProfileUseCase {
    private val repository = ImplProfileRepository()

    suspend fun getUserInfo(token: String): ProfileDomainModel? =
        repository.getUserInfo(token)
}