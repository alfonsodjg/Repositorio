package com.example.repositorio.ui.modules.home

import androidx.compose.runtime.Composable
import com.example.repositorio.ui.modules.home.view.HomeView

@Composable
fun HomeRecovery(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit
){
    HomeView(
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin
    )
}