package com.example.repositorio.navigation.destinations.login

import kotlinx.serialization.Serializable


sealed interface LoginDestinations {
    @Serializable
    object Login

    @Serializable
    object CreateAccount
    @Serializable
    object CreateAccountVerification
}