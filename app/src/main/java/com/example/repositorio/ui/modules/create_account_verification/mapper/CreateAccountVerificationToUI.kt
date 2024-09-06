package com.example.repositorio.ui.modules.create_account_verification.mapper

import com.example.repositorio.domain.modules.create_account_verification.model.CreateAccountVerificationDomainModel
import com.example.repositorio.ui.modules.create_account_verification.model.CreateAccountVerificationModelUI

fun CreateAccountVerificationDomainModel.toUI(): CreateAccountVerificationModelUI =
    CreateAccountVerificationModelUI(
        success = success
    )