package com.example.repositorio.ui.modules.reset_password.change_password.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.reset_password.usecase.GetChangePasswordUseCase
import com.example.repositorio.ui.modules.reset_password.change_password.viewstate.ChangePassViewState
import com.example.repositorio.ui.modules.reset_password.email_detail.mapper.toUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChangePasswordViewModel(
    private val changePasswordUseCase: GetChangePasswordUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(ChangePassViewState())
    val viewState = _viewState.asStateFlow()

    fun updateRequest(code: String, password: String) {
        _viewState.update {
            it.updateChangeRequest(code, password)
        }
    }

    fun onSendNewPassword(code: String, password: String) {
        viewModelScope.launch {
            val response = changePasswordUseCase(code, password)
            when (response) {
                is ServiceDomainHandler.Error -> {
                    println("Error: ${response.exception.code} message: ${response.exception.message}")
                }

                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateResponseUI(response = response.data.toUI())
                    }
                }
            }
        }
    }
}