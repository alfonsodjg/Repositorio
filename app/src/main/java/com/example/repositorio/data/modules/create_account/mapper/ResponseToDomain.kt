package com.example.repositorio.data.modules.create_account.mapper

import com.example.repositorio.data.modules.create_account.model.CreateAccountResponse
import com.example.repositorio.domain.modules.create_account.model.CreateAccountResponseDomainModel

fun CreateAccountResponse.toDomain(): CreateAccountResponseDomainModel =
    CreateAccountResponseDomainModel(
        status = status?: "",
        message = message?: ""
    )