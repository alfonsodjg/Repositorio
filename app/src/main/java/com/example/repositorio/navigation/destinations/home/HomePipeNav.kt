package com.example.repositorio.navigation.destinations.home

sealed class HomePipeNav{
    data object Home: HomePipeNav()
    data object Profile: HomePipeNav()
    data object About: HomePipeNav()
    data object Admin: HomePipeNav()
    data object AddFile:HomePipeNav()
    data object AddAuthor: HomePipeNav()
    data object LoginBack: HomePipeNav()
}