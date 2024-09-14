package com.example.repositorio.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.addautor.AddAuthorDestinations
import com.example.repositorio.navigation.destinations.addautor.AddAuthorPipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.navigation.utils.ScaffoldDefaults
import com.example.repositorio.ui.modules.add_author.AddAuthorRecovery

fun NavGraphBuilder.addAuthorGraph(
    startDestination: Any = AddAuthorDestinations.AddAuthor,
    onTopBarChange: (ScaffoldMainModel) -> Unit,
    navigateTo: (AddAuthorPipeNav) -> Unit
) {
    navigation<MainNavRoutes.AddAuthorRoot>(
        startDestination = startDestination
    ) {
        composable<AddAuthorDestinations.AddAuthor> {
            AddAuthorRecovery(
                onTopBarChange = {
                    onTopBarChange(
                        ScaffoldDefaults.navigateBar(
                            title = it,
                            enableActionIcon = true,
                            imgDarkSrc = "",
                            imgLightSrc = ""
                        )
                    )
                }
            )
        }
    }
}