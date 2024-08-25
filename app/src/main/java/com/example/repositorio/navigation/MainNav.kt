package com.example.repositorio.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.addfile.AddFileDestinations
import com.example.repositorio.navigation.destinations.addfile.AddFilePipeNav
import com.example.repositorio.navigation.destinations.home.HomeDestinations
import com.example.repositorio.navigation.destinations.home.HomePipeNav
import com.example.repositorio.navigation.destinations.login.LoginDestinations
import com.example.repositorio.navigation.destinations.login.LoginPipeNav
import com.example.repositorio.navigation.model.ScaffoldMainModel
import com.example.repositorio.navigation.navGraph.addFileGraph
import com.example.repositorio.navigation.navGraph.homeGraph
import com.example.repositorio.navigation.navGraph.loginGraph

@Composable
fun MainNav(
    navHostController: NavHostController,
    parentDestination: Any = MainNavRoutes.LoginRoot,
    innerPadding: PaddingValues,
    onTopBarChange: (ScaffoldMainModel) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = parentDestination,
        Modifier.padding(innerPadding)
    ) {
        loginGraph(
            onTopBarChange = onTopBarChange,
            navigateTo = { dest ->
                when (dest) {
                    LoginPipeNav.Login -> {
                        navHostController.navigate(
                            LoginDestinations.Login
                        )
                    }

                    LoginPipeNav.CreateAccount -> {
                        navHostController.navigate(
                            LoginDestinations.CreateAccount
                        )
                    }

                    LoginPipeNav.HomeApp -> {
                        navHostController.navigate(MainNavRoutes.HomeRoot)
                    }
                }
            }
        )
        homeGraph(
            onTopBarChange = onTopBarChange,
            navigateTo = {dest->
                when(dest){
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

                   is HomePipeNav.AddFile ->{
                        navHostController.navigate(
                            MainNavRoutes.AddFileRoot
                        )
                    }
                }
            }
        )
        addFileGraph(
            onTopBarChange = onTopBarChange,
            navigateTo = {dest->
                when(dest){
                    AddFilePipeNav.AddFile -> {
                        navHostController.navigate(AddFileDestinations.AddFile)
                    }
                }
            }
        )
    }
}