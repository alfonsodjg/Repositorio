package com.example.repositorio.ui.modules.admin

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.repositorio.ui.modules.admin.view.AdminView

@Composable
fun AdminRecovery(
    onGoToHome:()->Unit,
    onGoToProfile:()->Unit,
    onGoToAbout:()->Unit,
    onGoToAdmin:()->Unit,
    onGoToAddFile:()->Unit,
    onGoToAddAuthor:()->Unit,
    showBottomSheetLogOut: MutableState<Boolean>
){
    AdminView(
        onGoToHome = onGoToHome,
        onGoToProfile = onGoToProfile,
        onGoToAbout = onGoToAbout,
        onGoToAdmin = onGoToAdmin,
        onGoToAddFile = onGoToAddFile,
        onGoToAddAuthor = onGoToAddAuthor
    )
    BackHandler {
        showBottomSheetLogOut.value = true
    }
}