package com.example.repositorio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.components.bottomnavigation.ItemsMenu
import com.example.repositorio.ui.theme.view.MainView
import com.example.repositorio.ui.theme.view.bottomnavigationviews.AdminView
import com.example.repositorio.ui.modules.home.view.HomeView
import com.example.repositorio.ui.modules.about.InfoView
import com.example.repositorio.ui.modules.add_file_admin.view.AddFileAdminView
import com.example.repositorio.ui.modules.profile.view.ProfileRecovery
import com.example.repositorio.ui.modules.login.view.LoginView

@Composable
fun NavMain(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Login"){
        composable("Login"){ LoginView(navController = navController) }
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
