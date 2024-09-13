package com.example.repositorio.navigation.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.components.bottomsheet.BottomSheetRecovery
import com.example.repositorio.navigation.MainNav
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.model.TopBarUI
import com.example.repositorio.navigation.utils.ScaffoldDefaults

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainScaffold(
    parentDestinations: Any = MainNavRoutes.LoginRoot,
) {
    val mainNavController = rememberNavController()
    val topBarUI = remember { mutableStateOf(ScaffoldDefaults.default().topBar) }
    val showAlertBottomSheet = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBarRecovery(
                topBarUI = topBarUI.value,
                onBack = {
                    if (topBarUI.value is TopBarUI.NavigateBar) {
                        val navigateBar = topBarUI.value as TopBarUI.NavigateBar
                        if (navigateBar.showExitDialog) {
                            showAlertBottomSheet.value = true
                        } else {
                            mainNavController.popBackStack()
                        }
                    } else {
                        mainNavController.popBackStack()
                    }
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
            showAlertBottomSheet = showAlertBottomSheet
        )
    }
    if (showAlertBottomSheet.value) {
        BottomSheetRecovery(
            goToLogin = {
                mainNavController.navigate(MainNavRoutes.LoginRoot)
                showAlertBottomSheet.value = false
            },
            showBottomSheet = showAlertBottomSheet
        )
    }
}