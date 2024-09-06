package com.example.repositorio.ui.modules.reset_password.verification_code.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.usecase.GetResetPasswordVerificationUseCase
import com.example.repositorio.ui.core.utils.SaveCodeToChangePassword
import com.example.repositorio.ui.modules.reset_password.verification_code.mapper.toUI
import com.example.repositorio.ui.modules.reset_password.verification_code.viewstate.VerificationCodeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VerificationCodeViewModel(
    private val verificationUseCase: GetResetPasswordVerificationUseCase
): ViewModel() {

    private val _viewState = MutableStateFlow(VerificationCodeViewState())
    val viewState = _viewState.asStateFlow()

    fun updateCodeRequest(code: String){
        _viewState.update {
            it.updateCodeRequest(code)
        }
    }
    fun onSendCode(code: String){
        viewModelScope.launch {
            when(val response = verificationUseCase(code)){
                is ServiceDomainHandler.Error ->{
                    println("Ocurrio un error: ${response.exception.code} mesaage: ${response.exception.message}")
                }
                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateResponseUI(response = response.data.toUI(), isSuccess = true)
                    }
                    SaveCodeToChangePassword.code = _viewState.value.code
                }
            }
        }
    }
}