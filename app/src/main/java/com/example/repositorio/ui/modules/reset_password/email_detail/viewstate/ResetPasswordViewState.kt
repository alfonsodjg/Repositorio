package com.example.repositorio.ui.modules.reset_password.email_detail.viewstate

import com.example.repositorio.ui.modules.reset_password.email_detail.model.ResetPasswordModelUI

data class ResetPasswordViewState(
    val email: String = "",
    val response: ResetPasswordModelUI = ResetPasswordModelUI(),
    val success: Boolean = false
) {
    fun updateEmailRequest(email: String) = copy(email = email)
    fun updateResponseResetPass(response: ResetPasswordModelUI, success: Boolean) =
        copy(response = response, success = success)
}