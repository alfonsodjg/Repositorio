package com.example.repositorio.navigation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.navigation.MainNav
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.utils.ScaffoldDefaults

@Composable
fun MainScaffold(
    parentDestinations: Any = MainNavRoutes.LoginRoot,
) {
    val mainNavController = rememberNavController()
    val topBarUI = remember { mutableStateOf(ScaffoldDefaults.default().topBar) }

    Scaffold(
        topBar = {
            TopBarRecovery(
                topBarUI = topBarUI.value,
                onBack = {

                },
                onAction = {}
            )
        }
    ) { innerPadding ->
        MainNav(
            onTopBarChange = {
                topBarUI.value = it.topBar
            },
            navHostController = mainNavController,
            innerPadding = innerPadding,
        )
    }
}