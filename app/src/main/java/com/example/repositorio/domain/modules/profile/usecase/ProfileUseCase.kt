package com.example.repositorio.domain.modules.profile.usecase

import com.example.repositorio.data.modules.profile.repository.ImplProfileRepository
import com.example.repositorio.domain.modules.profile.model.ProfileDomainModel

class ProfileUseCase {
    private val repository = ImplProfileRepository()

    suspend fun getUserInfo(token: String): ProfileDomainModel? =
        repository.getUserInfo(token)
}