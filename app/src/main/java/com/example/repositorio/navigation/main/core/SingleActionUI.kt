package com.example.repositorio.navigation.main.core

sealed class SingleActionUI {
    data object ShowLoader : SingleActionUI()
    data object HideLoader : SingleActionUI()
    data object NavigateTo : SingleActionUI()
    data object None : SingleActionUI()
}