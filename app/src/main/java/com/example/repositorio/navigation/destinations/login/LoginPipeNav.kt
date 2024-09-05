package com.example.repositorio.navigation.destinations.login

sealed class LoginPipeNav {
    data object Login : LoginPipeNav()
    data object CreateAccount : LoginPipeNav()
    data object CreateAccountVerification: LoginPipeNav()
    data object HomeApp: LoginPipeNav()
}