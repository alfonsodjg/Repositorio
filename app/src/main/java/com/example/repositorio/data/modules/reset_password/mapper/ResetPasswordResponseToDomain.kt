package com.example.repositorio.data.modules.reset_password.mapper

import com.example.repositorio.data.modules.reset_password.model.ResetPassResponse
import com.example.repositorio.data.modules.reset_password.model.ResetPasswordVerificationResponse
import com.example.repositorio.domain.modules.reset_password.model.ResetPassVerificationDomainModel
import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordDomainModel

fun ResetPassResponse.toDomain(): ResetPasswordDomainModel =
    ResetPasswordDomainModel(
        email = email?: "",
        detail = detail?: ""
    )
fun ResetPasswordVerificationResponse.toDomain(): ResetPassVerificationDomainModel =
    ResetPassVerificationDomainModel(
        success = success?: ""
    )