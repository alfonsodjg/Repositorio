package com.example.repositorio.ui.modules.login.model

sealed class ErrorUi {
    data object ErrorCredentials: ErrorUi()
    data object ErrorServer: ErrorUi()
    data object ErrorRequest: ErrorUi()
    data object None: ErrorUi()
}