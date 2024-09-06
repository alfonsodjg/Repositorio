package com.example.repositorio.ui.modules.reset_password.change_password.viewstate

import com.example.repositorio.ui.modules.reset_password.email_detail.model.ResetPasswordModelUI
enum class SuccessResponse(val value: String){
    Success("Password reset.")
}
data class ChangePassViewState(
    val code: String = "",
    val password: String = "",
    val response: ResetPasswordModelUI = ResetPasswordModelUI()
) {
    fun updateChangeRequest(
        code: String,
        password: String
    ) = copy(code = code, password = password)

    fun updateResponseUI(response: ResetPasswordModelUI) = copy(response = response)
}