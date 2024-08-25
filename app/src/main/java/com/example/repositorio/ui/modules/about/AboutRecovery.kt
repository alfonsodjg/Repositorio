package com.example.repositorio.ui.modules.about

import androidx.compose.runtime.Composable
import com.example.repositorio.ui.modules.about.view.AboutView

@Composable
fun AboutRecovery(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit
){
    AboutView(
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin
    )
}