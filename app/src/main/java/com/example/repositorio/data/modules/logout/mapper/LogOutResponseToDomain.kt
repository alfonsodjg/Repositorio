package com.example.repositorio.data.modules.logout.mapper

import com.example.repositorio.data.modules.logout.model.LogOutResponse
import com.example.repositorio.domain.modules.logout.model.LogOutDomainModel

fun LogOutResponse.toDomain(): LogOutDomainModel =
    LogOutDomainModel(
        success = success ?: "",
        detail = detail?: ""
    )