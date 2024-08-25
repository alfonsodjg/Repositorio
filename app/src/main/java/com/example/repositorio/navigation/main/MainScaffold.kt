package com.example.repositorio.navigation.main

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.navigation.MainNav
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.destinations.home.HomeDestinations
import com.example.repositorio.navigation.destinations.home.HomePipeNav

@Composable
fun MainScaffold(
    parentDestinations: Any = MainNavRoutes.LoginRoot,
) {
    val mainNavController = rememberNavController()



    Scaffold() { innerPadding ->
        MainNav(
            navHostController = mainNavController,
            innerPadding = innerPadding, onTopBarChange = {}
        )
    }
}