package com.example.repositorio.ui.modules.login.viewstate

import com.example.repositorio.ui.modules.login.model.LoginModelUI

data class LoginViewState(
    val token: LoginModelUI = LoginModelUI(),
    var email: String = "",
    var password: String = ""
){
    fun updateCredentials(
        email: String,
        password: String
    ) = copy(email = email, password = password)

    fun updateToken(
        token: LoginModelUI
    ) = copy(token = token)
}
