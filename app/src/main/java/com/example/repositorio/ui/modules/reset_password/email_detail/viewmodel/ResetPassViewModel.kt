package com.example.repositorio.ui.modules.reset_password.email_detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.usecase.GetResetPasswordUseCase
import com.example.repositorio.ui.modules.reset_password.email_detail.mapper.toUI
import com.example.repositorio.ui.modules.reset_password.email_detail.viewstate.ResetPasswordViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResetPassViewModel(
    private val resetPasswordUseCase: GetResetPasswordUseCase
): ViewModel() {
    private val _viewState = MutableStateFlow(ResetPasswordViewState())
    val viewState = _viewState.asStateFlow()

    fun updateEmailRequest(email: String){
        _viewState.update {
            it.updateEmailRequest(email = email)
        }
    }
    fun onSendEmail(email: String){
        viewModelScope.launch {
            val response = resetPasswordUseCase(email)
            when(response){
                is ServiceDomainHandler.Error -> {
                    println("Ocurrio un error ${response.exception.code} message: ${response.exception.message}")
                }
                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateResponseResetPass(response = response.data.toUI(), success = true)
                    }
                }
            }
        }
    }
}