package com.example.repositorio.navigation.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.repositorio.components.bottomsheet.BottomSheetRecovery
import com.example.repositorio.core.utils.SaveToken
import com.example.repositorio.navigation.MainNav
import com.example.repositorio.navigation.destinations.MainNavRoutes
import com.example.repositorio.navigation.model.TopBarUI
import com.example.repositorio.navigation.utils.ScaffoldDefaults
import com.example.repositorio.ui.modules.share.shareviewmodel.ShareViewModelLogOut
import org.koin.androidx.compose.koinViewModel

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
    val showBottomSheetLogOut = remember {
        mutableStateOf(false)
    }
    val shareViewModel: ShareViewModelLogOut = koinViewModel()

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
            showAlertBottomSheet = showAlertBottomSheet,
            showBottomSheetLogOut = showBottomSheetLogOut,
            shareViewModel = shareViewModel
        )
    }
    if (showAlertBottomSheet.value) {
        BottomSheetRecovery(
            title = "Cancelar proceso",
            description = "Si cancelas el proceso es posible que pierdas todo el progreso para recuperar tu cuenta, tendras que volver a empezar la solicitud",
            textButton = "Permanecer",
            textSecondButton = "Cancelar",
            goToLogin = {
                mainNavController.navigate(MainNavRoutes.LoginRoot)
                showAlertBottomSheet.value = false
            },
            showBottomSheet = showAlertBottomSheet
        )
    }
    if (showBottomSheetLogOut.value) {
        BottomSheetRecovery(
            goToLogin = {
                shareViewModel.logOut(SaveToken.token?: "")
                mainNavController.navigate(MainNavRoutes.LoginRoot){
                    popUpTo(0) { inclusive = true }
                }
                showBottomSheetLogOut.value = false
            },
            showBottomSheet = showBottomSheetLogOut,
            title = "Cerrar sesion",
            description = "Estas a un paso de cerrar sesion ¿Estas seguro que deseas continuar?",
            textButton = "Permanecer",
            textSecondButton = "Continuar"
        )
    }
}