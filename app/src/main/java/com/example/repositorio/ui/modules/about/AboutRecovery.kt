package com.example.repositorio.ui.modules.about

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.repositorio.ui.modules.about.view.AboutView

@Composable
fun AboutRecovery(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit,
    showBottomSheetLogOut: MutableState<Boolean>
){
    AboutView(
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin
    )
    BackHandler {
        showBottomSheetLogOut.value = true
    }
}