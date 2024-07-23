package com.example.repositorio.domain.profile.repository

import com.example.repositorio.domain.profile.model.ProfileDomainModel

interface IProfileRepository {
    suspend fun getUserInfo(token: String): ProfileDomainModel?
}