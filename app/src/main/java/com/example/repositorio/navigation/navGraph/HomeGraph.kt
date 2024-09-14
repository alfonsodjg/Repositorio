package com.example.repositorio.navigation.navGraph

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.home.HomeDestinations
import com.example.repositorio.navigation.destinations.home.HomePipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.navigation.model.TopBarUI
import com.example.repositorio.ui.modules.about.AboutRecovery
import com.example.repositorio.ui.modules.admin.AdminRecovery
import com.example.repositorio.ui.modules.home.HomeRecovery
import com.example.repositorio.ui.modules.profile.view.ProfileRecovery
import com.example.repositorio.ui.modules.share.shareviewmodel.ShareViewModelLogOut

fun NavGraphBuilder.homeGraph(
    startDestination: Any = HomeDestinations.Home,
    onTopBarChange: (ScaffoldMainModel) -> Unit,
    navigateTo: (HomePipeNav) -> Unit,
    showBottomSheetLogOut:MutableState<Boolean>, //este parametro lo pasamos en todos, desde el main para tener un solo botomsheet,
    shareViewModel: ShareViewModelLogOut
) {
    navigation<MainNavRoutes.HomeRoot>(
        startDestination = startDestination
    ) {
        composable<HomeDestinations.Home> {
            LaunchedEffect(Unit) {
                onTopBarChange(ScaffoldMainModel(topBar = TopBarUI.NoActionBar))
            }
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
                },
                showBottomSheetLogOut = showBottomSheetLogOut
            )
        }
        composable<HomeDestinations.Profile> {
            LaunchedEffect(Unit) {
                onTopBarChange(ScaffoldMainModel(topBar = TopBarUI.NoActionBar))
            }
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
                },
                showBottomSheetLogOut = showBottomSheetLogOut,
                onLogOut = {
                    shareViewModel.logOut(SaveToken.token?: "")
                    navigateTo(HomePipeNav.LoginBack)
                }
            )
        }
        composable<HomeDestinations.About> {
            LaunchedEffect(Unit) {
                onTopBarChange(ScaffoldMainModel(topBar = TopBarUI.NoActionBar))
            }
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
                },
                showBottomSheetLogOut = showBottomSheetLogOut
            )
        }
        composable<HomeDestinations.Admin> {
            LaunchedEffect(Unit) {
                onTopBarChange(ScaffoldMainModel(topBar = TopBarUI.NoActionBar))
            }
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
                },
                onGoToAddAuthor = {
                    navigateTo(HomePipeNav.AddAuthor)
                },
                showBottomSheetLogOut = showBottomSheetLogOut
            )
        }
    }
}