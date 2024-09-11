package com.example.repositorio.ui.modules.login.viewstate

import com.example.repositorio.ui.modules.login.model.ErrorUi
import com.example.repositorio.ui.modules.login.model.LoginModelUI

data class LoginViewState(
    val token: LoginModelUI = LoginModelUI(),
    var email: String = "",
    var password: String = "",
    val isEnabledButton: Boolean = false,
    val error: ErrorUi = ErrorUi.None
){
    fun updateCredentials(
        email: String,
        password: String,
        isEnabledButton: Boolean
    ) = copy(email = email, password = password, isEnabledButton = isEnabledButton)

    fun updateToken(
        token: LoginModelUI
    ) = copy(token = token)

    fun updateError(
        error: ErrorUi
    ) = copy(error = error)
}
