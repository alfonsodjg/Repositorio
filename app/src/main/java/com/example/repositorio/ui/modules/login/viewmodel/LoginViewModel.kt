package com.example.repositorio.ui.modules.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.domain.core.handler.ServiceDomainHandler
import com.example.repositorio.domain.modules.login_auth.usecase.GetLoginAuthUseCase
import com.example.repositorio.ui.modules.login.mapper.toUI
import com.example.repositorio.ui.modules.login.model.ErrorUi
import com.example.repositorio.ui.modules.login.viewstate.LoginViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginAuthUseCase: GetLoginAuthUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState = _viewState.asStateFlow()

    fun updateCredentials(email: String, password: String){
        _viewState.update {
            it.updateCredentials(
                email = email,
                password = password
            )
        }
    }
    fun onLogin(email: String, password: String){
        viewModelScope.launch {
            when(val response = loginAuthUseCase(email, password)){
                is ServiceDomainHandler.Error -> {
                    println("Error en viewmodel ${response.exception.code} y ${response.exception.message}")
                    when(response.exception.code){
                        401-> {
                            _viewState.update {
                                it.updateError(error = ErrorUi.ErrorServer)
                            }
                        }
                        500-> {
                            _viewState.update {
                                it.updateError(error = ErrorUi.ErrorServer)
                            }
                        }
                    }
                }
                is ServiceDomainHandler.Success -> {
                    _viewState.update {
                        it.updateToken(
                            token = response.data.toUI()
                        )
                    }
                    response.data.token.let {
                        SaveToken.token = it
                    }
                }
            }
        }
    }
}