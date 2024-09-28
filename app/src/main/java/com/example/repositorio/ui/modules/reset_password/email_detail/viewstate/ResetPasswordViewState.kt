package com.example.repositorio.ui.modules.reset_password.email_detail.viewstate

import com.example.repositorio.ui.modules.login.model.ErrorUi
import com.example.repositorio.ui.modules.reset_password.email_detail.model.ResetPasswordModelUI

data class ResetPasswordViewState(
    val email: String = "",
    val response: ResetPasswordModelUI = ResetPasswordModelUI(),
    val success: Boolean = false,
    val error: ErrorUi = ErrorUi.None,
    val isEnabledButton: Boolean = false,
) {
    fun updateEmailRequest(email: String, isEnabledButton: Boolean) = copy(email = email, isEnabledButton = isEnabledButton)
    fun updateResponseResetPass(response: ResetPasswordModelUI, success: Boolean) =
        copy(response = response, success = success)

    fun updateError(error: ErrorUi) = copy(error = error)
}