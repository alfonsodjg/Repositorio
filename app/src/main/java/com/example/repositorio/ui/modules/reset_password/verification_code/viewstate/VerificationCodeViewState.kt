package com.example.repositorio.ui.modules.reset_password.verification_code.viewstate

import com.example.repositorio.ui.modules.reset_password.verification_code.model.ResetPassVerificationCodeModelUI

enum class SuccessVerified(val value: String){
    Succes("Email address verified.")
}
data class VerificationCodeViewState(
    val code: String = "",
    val response: ResetPassVerificationCodeModelUI = ResetPassVerificationCodeModelUI(),
    val isSuccess: Boolean = false
){
    fun updateCodeRequest(
       code: String
    ) = copy(code = code)

    fun updateResponseUI(
        response: ResetPassVerificationCodeModelUI,
        isSuccess: Boolean
    ) = copy(response = response, isSuccess = isSuccess)
}
