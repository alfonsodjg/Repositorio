package com.example.repositorio.navigation.destinations


import kotlinx.serialization.Serializable

sealed interface MainNavRoutes {
    @Serializable
    object HomeRoot

    @Serializable
    object LoginRoot

    @Serializable
    object AddFileRoot
}