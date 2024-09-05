package com.example.repositorio.ui.modules.create_account_verification.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account_verification.usecase.CreateAccountVerificationUseCase
import com.example.repositorio.ui.modules.create_account_verification.mapper.toUI
import com.example.repositorio.ui.modules.create_account_verification.viewstate.CreateAccountVerificationViewState
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateAccountVerificationViewModel(
    private val verificationUseCase: CreateAccountVerificationUseCase
): ViewModel() {
    private val _viewState = MutableStateFlow(CreateAccountVerificationViewState())
    val viewState = _viewState.asStateFlow()

    fun updateCode(code: String){
        _viewState.update {
            it.updateCode(code = code)
        }
    }
    fun onSendCode(code: String){
        viewModelScope.launch {
            val response = verificationUseCase(code)
            when(response.status.isSuccess()){
                true -> {
                    println("succes: ${response.status.value} y mensaje succes: ${response.status.description}")
                }
                false -> {
                    println("error ${response.status.value} y mensaje ${response.status.description}")
                }
            }
        }
    }
}