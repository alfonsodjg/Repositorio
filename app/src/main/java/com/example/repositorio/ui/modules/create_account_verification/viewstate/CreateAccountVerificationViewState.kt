package com.example.repositorio.ui.modules.create_account_verification.viewstate

import com.example.repositorio.ui.modules.create_account_verification.model.CreateAccountVerificationModelUI
import com.example.repositorio.ui.modules.create_account_verification.viewmodel.CreateAccountVerificationViewModel

data class CreateAccountVerificationViewState(
    val code: String = "",
    val verification: CreateAccountVerificationModelUI = CreateAccountVerificationModelUI()
) {
    fun updateCode(
        code: String
    ) = copy(code = code)

    fun updateResponseUI(
        verification: CreateAccountVerificationModelUI
    ) = copy(verification = verification)
}
