package com.example.repositorio.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.home.HomeDestinations
import com.example.repositorio.navigation.destinations.home.HomePipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.ui.modules.about.AboutRecovery
import com.example.repositorio.ui.modules.admin.AdminRecovery
import com.example.repositorio.ui.modules.home.HomeRecovery
import com.example.repositorio.ui.modules.profile.view.ProfileRecovery

fun NavGraphBuilder.homeGraph(
    startDestination: Any = HomeDestinations.Home,
    onTopBarChange: (ScaffoldMainModel) -> Unit,
    navigateTo: (HomePipeNav) -> Unit
) {
    navigation<MainNavRoutes.HomeRoot>(
        startDestination = startDestination
    ) {
        composable<HomeDestinations.Home> {
            HomeRecovery(
                onGoToHome = {
                    navigateTo(HomePipeNav.Home)
                },
                onGoToProfile = {
                    navigateTo(HomePipeNav.Profile)
                },
                onGoToAbout = {
                    navigateTo(HomePipeNav.About)
                },
                onGoToAdmin = {
                    navigateTo(HomePipeNav.Admin)
                }
            )
        }
        composable<HomeDestinations.Profile> {
            ProfileRecovery(
                onGoToHome = {
                    navigateTo(HomePipeNav.Home)
                },
                onGoToProfile = {
                    navigateTo(HomePipeNav.Profile)
                },
                onGoToAbout = {
                    navigateTo(HomePipeNav.About)
                },
                onGoToAdmin = {
                    navigateTo(HomePipeNav.Admin)
                }
            )
        }
        composable<HomeDestinations.About> {
            AboutRecovery(
                onGoToHome = {
                    navigateTo(HomePipeNav.Home)
                },
                onGoToProfile = {
                    navigateTo(HomePipeNav.Profile)
                },
                onGoToAbout = {
                    navigateTo(HomePipeNav.About)
                },
                onGoToAdmin = {
                    navigateTo(HomePipeNav.Admin)
                }
            )
        }
        composable<HomeDestinations.Admin> {
            AdminRecovery(
                onGoToHome = {
                    navigateTo(HomePipeNav.Home)
                },
                onGoToProfile = {
                    navigateTo(HomePipeNav.Profile)
                },
                onGoToAbout = {
                    navigateTo(HomePipeNav.About)
                },
                onGoToAdmin = {
                    navigateTo(HomePipeNav.Admin)
                },
                onGoToAddFile = {
                    navigateTo(HomePipeNav.AddFile)
                }
            )
        }
    }
}