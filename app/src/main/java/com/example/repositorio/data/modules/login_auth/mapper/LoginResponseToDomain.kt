package com.example.repositorio.data.modules.login_auth.mapper

import com.example.repositorio.data.modules.login_auth.model.LoginResponse
import com.example.repositorio.domain.modules.login_auth.model.LoginDomainModel

fun LoginResponse.toDomain(): LoginDomainModel =
    LoginDomainModel(
        token = token
    )