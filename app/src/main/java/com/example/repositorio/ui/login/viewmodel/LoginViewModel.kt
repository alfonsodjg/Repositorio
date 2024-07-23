package com.example.repositorio.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.data.login.model.LoginResponse
import com.example.repositorio.domain.login.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val loginUseCase = LoginUseCase()

    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginResponse:LiveData<LoginResponse?> = _loginResponse

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _showErrorMessage = MutableLiveData<Boolean>(false)
    val showErrorMessage: LiveData<Boolean> = _showErrorMessage

    fun onChangeText(email: String, password: String){
        _email.value = email
        _password.value = password
    }

    fun onLogin(email: String, password: String){
        viewModelScope.launch {
            val response = loginUseCase(email, password)
            _loginResponse.value = response
            response?.token?.let {
                SaveToken.token = it
            }
            println("Token: ${loginResponse.value?.token}")

            _showErrorMessage.value = response?.token==null
        }
    }
}