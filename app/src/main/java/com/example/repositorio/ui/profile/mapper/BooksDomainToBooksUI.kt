package com.example.repositorio.ui.profile.mapper

import com.example.repositorio.domain.profile.model.ProfileDomainModel
import com.example.repositorio.ui.profile.model.UserInfoModelUI

fun ProfileDomainModel.toUI() = UserInfoModelUI(
    first_name = first_name,
    last_name = last_name,
    apellido_materno = apellido_materno,
    matricula = matricula
)
