package com.example.repositorio.ui.modules.login.mapper

import com.example.repositorio.domain.modules.login_auth.model.LoginDomainModel
import com.example.repositorio.ui.modules.login.model.LoginModelUI

fun LoginDomainModel.toUI(): LoginModelUI =
    LoginModelUI(
        token = token
    )