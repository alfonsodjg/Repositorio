package com.example.repositorio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.components.bottomnavigation.ItemsMenu
import com.example.repositorio.ui.login.view.LoginView
import com.example.repositorio.ui.theme.view.MainView
import com.example.repositorio.ui.theme.view.bottomnavigationviews.AdminView
import com.example.repositorio.ui.home.view.HomeView
import com.example.repositorio.ui.about.InfoView
import com.example.repositorio.ui.add_file_admin.view.AddFileAdminView
import com.example.repositorio.ui.profile.view.ProfileRecovery
import com.example.repositorio.ui.login.viewmodel.LoginViewModel

@Composable
fun NavMain(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Login"){
        composable("Login"){ LoginView(viewModel = LoginViewModel(), navController) }
        composable("MainView"){ MainView(navController)}
    }
}
@Composable
fun MainNavHost(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = ItemsMenu.Home.route
    ) {
        composable(ItemsMenu.Home.route) { HomeView(navController) }
        composable(ItemsMenu.Profile.route) { ProfileRecovery() }
        composable(ItemsMenu.Info.route) { InfoView() }
        composable(ItemsMenu.Admin.route) { AdminView(navController) }
        composable("AddFileAdminView") { AddFileAdminView(navController) }
    }
}
