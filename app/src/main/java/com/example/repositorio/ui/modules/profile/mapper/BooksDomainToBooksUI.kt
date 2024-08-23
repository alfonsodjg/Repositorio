package com.example.repositorio.ui.modules.profile.mapper

import com.example.repositorio.domain.modules.profile.model.ProfileDomainModel
import com.example.repositorio.ui.modules.profile.model.UserInfoModelUI

fun ProfileDomainModel.toUI() = UserInfoModelUI(
    first_name = first_name,
    last_name = last_name,
    apellido_materno = apellido_materno,
    matricula = matricula
)
