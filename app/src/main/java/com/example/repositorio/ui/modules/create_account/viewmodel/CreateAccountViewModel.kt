package com.example.repositorio.ui.modules.create_account.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.create_account.usecase.GetCreateAccountUseCase
import com.example.repositorio.ui.modules.create_account.mapper.toUI
import com.example.repositorio.ui.modules.create_account.viewstate.CreateAccountViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateAccountViewModel(
    private val getCreateAccountUseCase: GetCreateAccountUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(CreateAccountViewState())
    val viewState = _viewState.asStateFlow()

    fun updateRequest(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        matricula: String,
        apellidoMaterno: String
    ) {
        viewModelScope.launch {
            _viewState.update {
                it.updateRequest(
                    email,
                    password,
                    firstName,
                    lastName,
                    matricula,
                    apellidoMaterno
                )
            }
        }
    }

    fun onCreateAccount(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        matricula: String,
        apellidoMaterno: String
    ) {
        viewModelScope.launch {
            val response = getCreateAccountUseCase(
                email,
                password,
                firstName,
                lastName,
                matricula,
                apellidoMaterno
            )
            when (response) {
                is ServiceDomainHandler.Error -> {
                    println("Error al crear cuenta: ${response.exception.message} code: ${response.exception.code}")
                }

                is ServiceDomainHandler.Success -> {

                    if (response.data.status == "success") {
                        _viewState.update {
                            it.updateCreateAccount(
                                createAccountModelUI = response.data.toUI(),
                                isCreatedAccount = true
                            )
                        }
                    }
                }
            }
        }
    }
}