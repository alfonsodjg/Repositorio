package com.example.repositorio.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.addautor.AddAuthorDestinations
import com.example.repositorio.navigation.destinations.addautor.AddAuthorPipeNav
import com.example.repositorio.navigation.destinations.addfile.AddFileDestinations
import com.example.repositorio.navigation.destinations.addfile.AddFilePipeNav
import com.example.repositorio.navigation.destinations.home.HomeDestinations
import com.example.repositorio.navigation.destinations.home.HomePipeNav
import com.example.repositorio.navigation.destinations.login.LoginDestinations
import com.example.repositorio.navigation.destinations.login.LoginPipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.navigation.navGraph.addAuthorGraph
import com.example.repositorio.navigation.navGraph.addFileGraph
import com.example.repositorio.navigation.navGraph.homeGraph
import com.example.repositorio.navigation.navGraph.loginGraph
import com.example.repositorio.ui.modules.share.shareviewmodel.ShareViewModelLogOut

@Composable
fun MainNav(
    navHostController: NavHostController,
    parentDestination: Any = MainNavRoutes.LoginRoot,
    innerPadding: PaddingValues,
    onTopBarChange: (ScaffoldMainModel) -> Unit,
    showAlertBottomSheet: MutableState<Boolean>,
    showBottomSheetLogOut: MutableState<Boolean>,
    shareViewModel: ShareViewModelLogOut
) {
    NavHost(
        navController = navHostController,
        startDestination = parentDestination,
        Modifier.padding(innerPadding)
    ) {
        loginGraph(
            showAlertBottomSheet = showAlertBottomSheet,
            onTopBarChange = onTopBarChange,
            navigateTo = { dest ->
                when (dest) {
                    is LoginPipeNav.Login -> {
                        navHostController.navigate(
                            LoginDestinations.Login
                        )
                    }

                    is LoginPipeNav.CreateAccount -> {
                        navHostController.navigate(
                            LoginDestinations.CreateAccount
                        )
                    }

                    is LoginPipeNav.CreateAccountVerification -> {
                        navHostController.navigate(LoginDestinations.CreateAccountVerification)
                    }

                    is LoginPipeNav.ResetPassword -> {
                        navHostController.navigate(LoginDestinations.ResetPassword)
                    }

                    is LoginPipeNav.ResetPasswordVerification -> {
                        navHostController.navigate(LoginDestinations.ResetPasswordVerification)
                    }

                    is LoginPipeNav.ResetPasswordChangePassword -> {
                        navHostController.navigate(LoginDestinations.ResetPasswordChangePassword)
                    }

                    is LoginPipeNav.HomeApp -> {
                        navHostController.navigate(MainNavRoutes.HomeRoot)
                    }
                }
            }
        )
        homeGraph(
            onTopBarChange = onTopBarChange,
            showBottomSheetLogOut = showBottomSheetLogOut,
            shareViewModel = shareViewModel,
            navigateTo = { dest ->
                when (dest) {
                    is HomePipeNav.About -> {
                        navHostController.navigate(
                            HomeDestinations.About
                        )
                    }

                    is HomePipeNav.Admin -> {
                        navHostController.navigate(HomeDestinations.Admin)
                    }

                    is HomePipeNav.Home -> {
                        navHostController.navigate(
                            HomeDestinations.Home
                        )
                    }

                    is HomePipeNav.Profile -> {
                        navHostController.navigate(
                            HomeDestinations.Profile
                        )
                    }

                    is HomePipeNav.AddFile -> {
                        navHostController.navigate(
                            MainNavRoutes.AddFileRoot
                        )
                    }

                    is HomePipeNav.AddAuthor -> {
                        navHostController.navigate(
                            MainNavRoutes.AddAuthorRoot
                        )
                    }

                    is HomePipeNav.LoginBack -> {
                        navHostController.navigate(MainNavRoutes.LoginRoot){
                            popUpTo(0) { inclusive = true }
                        }
                    }
                }
            }
        )
        addFileGraph(
            onTopBarChange = onTopBarChange,
            navigateTo = { dest ->
                when (dest) {
                    AddFilePipeNav.AddFile -> {
                        navHostController.navigate(AddFileDestinations.AddFile)
                    }
                }
            }
        )
        addAuthorGraph(
            onTopBarChange = onTopBarChange,
            navigateTo = { dest ->
                when (dest) {
                    AddAuthorPipeNav.AddAuthor -> {
                        navHostController.navigate(AddAuthorDestinations.AddAuthor)
                    }
                }
            }
        )
    }
}