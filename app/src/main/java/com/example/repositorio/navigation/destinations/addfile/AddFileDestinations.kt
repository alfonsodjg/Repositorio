package com.example.repositorio.navigation.destinations.addfile

import kotlinx.serialization.Serializable

sealed interface AddFileDestinations {
    @Serializable
    object AddFile
}