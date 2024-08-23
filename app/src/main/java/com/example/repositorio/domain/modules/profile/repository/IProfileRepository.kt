package com.example.repositorio.domain.modules.profile.repository

import com.example.repositorio.domain.modules.profile.model.ProfileDomainModel

interface IProfileRepository {
    suspend fun getUserInfo(token: String): ProfileDomainModel?
}