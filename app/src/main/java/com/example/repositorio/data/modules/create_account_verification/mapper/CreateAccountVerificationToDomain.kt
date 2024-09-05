package com.example.repositorio.data.modules.create_account_verification.mapper

import com.example.repositorio.data.modules.create_account_verification.model.CreateAccountVerificationResponse
import com.example.repositorio.domain.modules.create_account_verification.model.CreateAccountVerificationDomainModel

fun CreateAccountVerificationResponse.toDomain(): CreateAccountVerificationDomainModel =
    CreateAccountVerificationDomainModel(
        success = success?: "",
        detail = detail?: ""
    )