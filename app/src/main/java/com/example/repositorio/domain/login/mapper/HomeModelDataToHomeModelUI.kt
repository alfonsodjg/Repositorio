package com.example.repositorio.domain.login.mapper

import com.example.repositorio.domain.login.model.LoginResponseDomainModel
import com.example.repositorio.domain.login.model.UserDomainModel
import com.example.repositorio.ui.login.model.LoginModelUI
import com.example.repositorio.ui.login.model.LoginResponseModelUI

fun UserDomainModel.toHomeUI(): LoginModelUI{
    return LoginModelUI(
        email = email,
        password = password
    )
}

fun LoginResponseDomainModel.toResponseUI() : LoginResponseModelUI{
    return LoginResponseModelUI(
        token = token
    )
}