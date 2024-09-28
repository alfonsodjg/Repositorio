package com.example.repositorio.ui.modules.reset_password.email_detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.usecase.GetResetPasswordUseCase
import com.example.repositorio.navigation.main.core.SingleActionUI
import com.example.repositorio.ui.modules.login.model.ErrorUi
import com.example.repositorio.ui.modules.reset_password.email_detail.mapper.toUI
import com.example.repositorio.ui.modules.reset_password.email_detail.viewstate.ResetPasswordViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResetPassViewModel(
    private val resetPasswordUseCase: GetResetPasswordUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(ResetPasswordViewState())
    val viewState = _viewState.asStateFlow()

    private val _sharedFlow: MutableSharedFlow<SingleActionUI> = MutableSharedFlow()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun updateEmailRequest(email: String) {
        _viewState.update {
            it.updateEmailRequest(
                email = email,
                isEnabledButton = email.isNotEmpty() && email.length > 7
            )
        }
    }

    fun onSendEmail(email: String) {
        viewModelScope.launch {
            _sharedFlow.emit(SingleActionUI.ShowLoader)
            when (val response = resetPasswordUseCase(email)) {
                is ServiceDomainHandler.Error -> {
                    _sharedFlow.emit(SingleActionUI.HideLoader)
                    println("Ocurrio un error ${response.exception.code} message: ${response.exception.message}")
                    when (response.exception.code) {
                        0 -> {
                            _viewState.update {
                                it.updateError(error = ErrorUi.ErrorServer)
                            }
                        }

                        400 -> {
                            _viewState.update {
                                it.updateError(error = ErrorUi.ErrorRequest)
                            }
                        }
                    }
                }

                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateResponseResetPass(response = response.data.toUI(), success = true)
                    }
                    _sharedFlow.emit(SingleActionUI.HideLoader)
                }
            }
        }
    }

    fun clearError() {
        _viewState.update {
            it.updateError(error = ErrorUi.None)
        }
    }
}