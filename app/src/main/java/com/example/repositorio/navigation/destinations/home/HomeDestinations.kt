package com.example.repositorio.navigation.destinations.home

import android.os.Parcelable
import kotlinx.serialization.Serializable
import kotlinx.parcelize.Parcelize

sealed interface HomeDestinations {

    @Serializable
    object Home

    @Serializable
    object About

    @Serializable
    object Profile

    @Serializable
    object Admin
}