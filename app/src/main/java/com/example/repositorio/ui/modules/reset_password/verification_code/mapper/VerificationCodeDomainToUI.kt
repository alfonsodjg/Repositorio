package com.example.repositorio.ui.modules.reset_password.verification_code.mapper

import com.example.repositorio.domain.modules.reset_password.model.ResetPassVerificationDomainModel
import com.example.repositorio.ui.modules.reset_password.verification_code.model.ResetPassVerificationCodeModelUI

fun ResetPassVerificationDomainModel.toUI(): ResetPassVerificationCodeModelUI =
    ResetPassVerificationCodeModelUI(
        success = success
    )