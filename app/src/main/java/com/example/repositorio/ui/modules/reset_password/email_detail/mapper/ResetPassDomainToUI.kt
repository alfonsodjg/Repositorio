package com.example.repositorio.ui.modules.reset_password.email_detail.mapper

import com.example.repositorio.domain.modules.reset_password.model.ResetPasswordDomainModel
import com.example.repositorio.ui.modules.reset_password.email_detail.model.ResetPasswordModelUI

fun ResetPasswordDomainModel.toUI(): ResetPasswordModelUI =
    ResetPasswordModelUI(
        email = email,
        detail = detail
    )