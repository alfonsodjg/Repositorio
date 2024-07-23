package com.example.repositorio.ui.login.viewstate

import com.example.repositorio.ui.login.model.LoginModelUI
import com.example.repositorio.ui.login.model.LoginResponseModelUI

data class LoginViewState(
    val userLoginModelUI: LoginModelUI = LoginModelUI("", ""),
    val loginResponse: LoginResponseModelUI = LoginResponseModelUI(""),
    val showErrorMessage: Boolean = false
) {
    fun updateUser(userLoginModelUI: LoginModelUI) = copy(
        userLoginModelUI= userLoginModelUI,
        loginResponse = loginResponse,
        showErrorMessage = showErrorMessage
    )
}