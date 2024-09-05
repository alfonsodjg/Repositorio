package com.example.repositorio.ui.modules.create_account.viewstate

import com.example.repositorio.ui.modules.create_account.model.CreateAccountModelUI

data class CreateAccountViewState(
    val email: String = "",
    val password: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val matricula: String = "",
    val apellidoMaterno: String = "",
    val createAccountModelUI: CreateAccountModelUI = CreateAccountModelUI(),
    val isCreatedAccount: Boolean = false
) {
    fun updateCreateAccount(
        createAccountModelUI: CreateAccountModelUI,
        isCreatedAccount: Boolean
    ) = copy(
        createAccountModelUI = createAccountModelUI,
        isCreatedAccount = isCreatedAccount
    )

    fun updateRequest(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        matricula: String,
        apellidoMaterno: String
    ) = copy(
        email = email,
        password = password,
        firstName = firstName,
        lastName = lastName,
        matricula = matricula,
        apellidoMaterno = apellidoMaterno
    )
}