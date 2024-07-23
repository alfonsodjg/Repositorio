package com.example.repositorio.ui.theme.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.components.bottomnavigation.ItemsMenu
import com.example.repositorio.navigation.MainNavHost


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(navController: NavController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { NavigationContainer(bottomNavController) }
    ) {
        MainNavHost(navController = bottomNavController)
    }
}

@Composable
fun NavigationContainer(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val menuItemList = listOf(
        ItemsMenu.Home,
        ItemsMenu.Profile,
        ItemsMenu.Info,
        ItemsMenu.Admin
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Blue
    ) {
        menuItemList.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(painterResource(id = item.icon),
                        contentDescription = item.title,
                    )},
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


