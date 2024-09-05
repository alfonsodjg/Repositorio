package com.example.repositorio.ui.modules.create_account.mapper

import com.example.repositorio.domain.modules.create_account.model.CreateAccountResponseDomainModel
import com.example.repositorio.ui.modules.create_account.model.CreateAccountModelUI

fun CreateAccountResponseDomainModel.toUI(): CreateAccountModelUI =
    CreateAccountModelUI(
        status = status,
        message = message
    )