package com.example.repositorio.navigation.destinations.addautor

import kotlinx.serialization.Serializable

sealed interface AddAuthorDestinations {
    @Serializable
    object AddAuthor
}