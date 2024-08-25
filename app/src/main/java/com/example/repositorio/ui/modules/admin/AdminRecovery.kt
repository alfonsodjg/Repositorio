package com.example.repositorio.ui.modules.admin

import androidx.compose.runtime.Composable
import com.example.repositorio.ui.modules.admin.view.AdminView

@Composable
fun AdminRecovery(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit,
    onGoToAddFile:()->Unit,
    onGoToAddAuthor:()->Unit
){
    AdminView(
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin,
        onGoToAddFile = onGoToAddFile,
        onGoToAddAuthor = onGoToAddAuthor
    )
}